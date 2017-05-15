package com.tktick.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 验证
 * 由此注解的方法中有参数对象也拥有此注解
 * 参数中的属性也拥有此注解
 * @author user
 *
 */
@Target({ElementType.TYPE, ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Validation {
	/**
	 * 用于判断参数或属性的正则表达式名称
	 * @return
	 */
	String regex() default "";
	/**
	 * 不能为空
	 * @return
	 */
	boolean notNull() default false;
	/**
	 * 不能为空字符串
	 * @return
	 */
	boolean notEmpty() default false;
	/**
	 * 电子邮箱
	 * @return
	 */
	boolean email() default false;
}
