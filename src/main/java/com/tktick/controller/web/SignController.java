package com.tktick.controller.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import com.tktick.annotation.Validation;
import com.tktick.model.constant.AuthConstant;
import com.tktick.model.entity.TkUser;
import com.tktick.model.form.LoginForm;
import com.tktick.service.TkUserService;
import com.tktick.utils.StringUtil;
import com.tktick.utils.WebUtil;

/**
 * 登录注册等控制器
 * @author user
 *
 */
@RestController
@RequestMapping("/sign")
public class SignController extends WebBaseController {
	
	@Autowired
	private TkUserService userService;
	
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
	
	/**
	 * 登录
	 * @return
	 */
	@RequestMapping("/session.html")
	@Validation
	public ModelAndView session(LoginForm form){
		TkUser user = userService.valiLoginUser(form);
		if(user != null){
			System.err.println("登录成功:" + user.getUserEmail());
			String sessionId = StringUtil.uuid(false) + "|" +user.getUserId();
			//将sessionId存放在缓存中
			
			WebUtil.addCookie(response, null, null, true, AuthConstant.COOKIE_SESSION_ID, sessionId, 1000);
			return new ModelAndView("redirect:/");
		}
		
		System.err.println("登录失败");
		return new ModelAndView("redirect:/sign/in.html");
	}
}
