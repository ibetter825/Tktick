package com.tktick.controller.web;

import java.util.Map;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import com.tktick.bean.form.LoginForm;
import com.tktick.service.TkUserService;

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
		boolean res = userService.valiLoginUser(response, form);
		if(res){
			System.err.println("登录成功");
			return new ModelAndView("redirect:/");
		}
		
		System.err.println("登录失败");
		return new ModelAndView("redirect:/sign/in.html");
	}
}
