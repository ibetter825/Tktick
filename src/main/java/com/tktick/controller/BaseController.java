package com.tktick.controller;

import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RestController;
import com.google.common.collect.Maps;
import com.tktick.bean.constant.AuthConstant;
import com.tktick.bean.entity.TkUser;
import com.tktick.bean.model.ResultModel;
import com.tktick.context.SessionContextHolder;

@RestController
public class BaseController {
	@Autowired  
	protected HttpServletRequest request;
	@Autowired
	protected HttpServletResponse response;
	/**
	 * 验证器存在错误消息的封装
	 * @param error
	 * @return
	 */
	public ResultModel resultErrors(BindingResult error){
		Map<String, String> res = null;
		if(error.hasErrors()){
			res = Maps.newHashMap();//验证错误结果  failed:message
			List<ObjectError>  errors = error.getAllErrors();
			for(ObjectError e : errors){
				if(e instanceof FieldError)
					res.put(((FieldError) e).getField(), e.getDefaultMessage());
			}
		}
		ResultModel model = null;
		if(res != null){
			model = new ResultModel(AuthConstant.FORM_VALI_FAIL_MSG);
			model.getData().put(AuthConstant.FORM_VALI_FAIL_NAME, res);
		}
		return model;
	}
	/**
	 * 获取当前登录的用户
	 * @return
	 */
	public TkUser getCurrentUser(){
		return SessionContextHolder.getCurrentUser();
	}
	/**
	 * 获取系统根目录
	 * @return
	 */
	public String getContextPath(String path){
		return request.getServletContext().getRealPath(path);
	}

	/**
	 * 添加request请求属性
	 * @param key
	 * @param val
	 */
	public void setAttr(String key, Object val){
		request.setAttribute(key, val);
	}
	/**
	 * 获取request请求属性
	 * @param key
	 * @return
	 */
	public Object getAttr(String key){
		return request.getAttribute(key);
	}
}
