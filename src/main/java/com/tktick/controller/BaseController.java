package com.tktick.controller;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RestController;
import com.google.common.collect.Maps;
import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGImageEncoder;

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
	public Map<String, String> resultErrors(BindingResult error){
		Map<String, String> res = null;
		if(error.hasErrors()){
			res = Maps.newHashMap();//验证错误结果  failed:message
			List<ObjectError>  errors = error.getAllErrors();
			for(ObjectError e : errors){
				if(e instanceof FieldError)
					res.put(((FieldError) e).getField(), e.getDefaultMessage());
			}
		}
		return res;
	}
	/**
	 * 发送图片到前台
	 * @throws IOException 
	 */
	public void renderImage(Object res) throws IOException{
		response.setContentType("image/jpeg");
		ServletOutputStream out = response.getOutputStream();
        JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(out);
        encoder.encode((BufferedImage) res);
        out.flush();
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
