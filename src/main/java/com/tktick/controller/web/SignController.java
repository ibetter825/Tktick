package com.tktick.controller.web;

import java.io.IOException;
import java.util.Map;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.tktick.bean.constant.AuthConstant;
import com.tktick.bean.form.LoginForm;
import com.tktick.service.TkUserService;
import com.tktick.utils.CaptchaUtil;
import com.tktick.utils.Md5Util;
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
		return new ModelAndView("web/sign");
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
	public ModelAndView session(@Valid LoginForm form, BindingResult vali){
		Map<String, String> errors = resultErrors(vali);
		if(errors != null) return new ModelAndView("redirect:/sign/in.html", errors);
		boolean res = userService.valiLoginUser(request, response, form);
		if(res){
			System.err.println("登录成功");
			return new ModelAndView("redirect:/");
		}
		
		System.err.println("登录失败");
		return new ModelAndView("redirect:/sign/in.html");
	}
	
	/**
	 * 获取验证码
	 * @throws IOException 
	 */
	@RequestMapping("/captcha.jpg")
	public void captcha() throws IOException{
		Object[] res = CaptchaUtil.getBufferedImageAndCode(100, 30);
		String captchaString = Md5Util.md5(res[0].toString().toUpperCase() + AuthConstant.COOKIE_CAPTCHA_SALT);
		WebUtil.addCookie(response, null, AuthConstant.COOKIE_CAPTCHA_PATH, true, AuthConstant.COOKIE_CAPTCHA_NAME, captchaString, 0);
		renderImage(res[1]);
	}
}
