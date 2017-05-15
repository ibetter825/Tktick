package com.tktick.interceptor;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import com.google.common.collect.Maps;
import com.tktick.annotation.Validation;
import com.tktick.exception.TkValidationException;
import com.tktick.model.form.BaseForm;
import com.tktick.utils.StringUtil;

/**
 * 使用 AOP检查对象字段是否匹配
 * @author user
 *
 */
//@Aspect
//@Component
public class ValidationInterceptor {
	
	@Before("@annotation(vali)")//会拦截注解vali的方法，否则不拦截
    public void validate(JoinPoint point, Validation vali) throws Throwable {
        Object[] args = point.getArgs();//方法中的参数
        for (Object arg : args) {
        	if(isObjectContainValiAnno(arg) && isFormObject(arg))
        		valiFormObjFields(arg);
		}
    }
	
	/**
	 * 验证form表单属性
	 * @param obj
	 */
	private void valiFormObjFields(Object obj){
		Field[] fields = obj.getClass().getDeclaredFields();
		Validation vali = null;
		Method method = null;
		Object value = null;
		String res = null;
		Map<String, String> errors = null;
		for (Field field : fields) {
			if(isArrayContainValiAnno(field.getDeclaredAnnotations())){
				vali = field.getAnnotation(Validation.class);
				try {
					method = obj.getClass().getMethod("get" + StringUtil.toLowerCaseInitial(field.getName(), false), new Class[0]);
					try {
						value = method.invoke(obj, new Object[0]);
						res = valiFormObjFieldValue(value, vali);
						if(res != null){
							if(errors == null) errors = Maps.newHashMap();
							errors.put(field.getName(), res);
						}
						System.err.println("属性值:" + value);
					} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
						e.printStackTrace();
						throw new TkValidationException("验证出现错误:调用对象方法失败");
					}
				} catch (NoSuchMethodException | SecurityException e) {
					e.printStackTrace();
					throw new TkValidationException("验证出现错误:对象属性没有对应getter方法");
				}
				System.err.println("验证规则:" + vali.regex());
			}
		}
		
		if(errors != null)
			throw new TkValidationException("表单验证错误", errors);
	}
	
	/**
	 * 验证属性
	 * @param value
	 * @param vali
	 * @return
	 */
	private String valiFormObjFieldValue(Object value, Validation vali){
		if(vali.notNull() && value == null) return "不能为空";
		if(vali.email()){
			if(value != null && !StringUtil.isEmail(value.toString())) return "邮箱格式不正确";
		}
		if(vali.notEmpty() && !StringUtil.isNotEmpty(value)) return "不能为空字符串";
		String regex = vali.regex();
		if(!"".equals(regex)){
			
		}
		return null;
	}
	
	/**
	 * 是否是表单对象
	 * @param target
	 * @return
	 */
	private boolean isFormObject(Object target){
		return target instanceof BaseForm;
	}
	
	/**
	 * 对象是否包含验证注解
	 * @param annos
	 * @return
	 */
	private boolean isObjectContainValiAnno(Object target){
		return target.getClass().getAnnotation(Validation.class) != null;
	}
	
	/**
	 * 注解数组是否包含验证注解
	 * @param annos
	 * @return
	 */
	private boolean isArrayContainValiAnno(Annotation[] annos){
		for (Annotation a : annos) {
			if(a instanceof Validation)
				return true;
		}
		return false;
	}
}
