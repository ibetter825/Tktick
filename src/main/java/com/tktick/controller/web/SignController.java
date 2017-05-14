package com.tktick.controller.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * 登录注册等控制器
 * @author user
 *
 */
@RestController
@RequestMapping("/sign")
public class SignController extends WebBaseController {
	
	@RequestMapping("/in.html")
	public ModelAndView in(){
		return new ModelAndView("web/signin");
	}
	
	/**
	 * 跳转到写文章页面
	 * @return
	 */
	@RequestMapping("/out.html")
	public String out(){
		return "退出成功";
	}
}
