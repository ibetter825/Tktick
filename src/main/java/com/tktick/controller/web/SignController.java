package com.tktick.controller.web;

import java.io.IOException;
import java.util.Map;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import com.tktick.bean.constant.AuthConstant;
import com.tktick.bean.form.LoginForm;
import com.tktick.bean.model.ResultModel;
import com.tktick.service.TkUserService;
import com.tktick.utils.Md5Util;
import com.tktick.utils.VerifyCodeUtil;
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
	@RequestMapping(value = "/session.json", method = RequestMethod.POST)
	public ResultModel session(@Valid LoginForm form, BindingResult vali){
		ResultModel model = null;
		Map<String, String> errors = resultErrors(vali);
		if(errors != null){
			model = new ResultModel(AuthConstant.LOGIN_FORM_VALUE_ERROR);
			model.getData().put("errors", errors);
			return model;
		}
		String res = userService.valiLoginUser(request, response, form);
		if(res == null){
			System.err.println("登录成功");
			model = new ResultModel();
			return model;
		}
		
		System.err.println("登录失败");
		model = new ResultModel(res);
		return model;
	}
	
	/**
	 * 获取验证码
	 * @throws IOException 
	 */
	@RequestMapping("/captcha.jpg")
	public void captcha() throws IOException{
		response.setHeader("Pragma", "No-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expires", 0);
        response.setContentType("image/jpeg");
        
        //生成随机字串 
        String verifyCode = VerifyCodeUtil.generateVerifyCode(4);
        String captchaString = Md5Util.md5(verifyCode.toUpperCase() + AuthConstant.COOKIE_CAPTCHA_SALT);
        WebUtil.addCookie(response, null, AuthConstant.COOKIE_CAPTCHA_PATH, true, AuthConstant.COOKIE_CAPTCHA_NAME, captchaString, -1);
        //生成图片
        int w = 150, h = 40;
        VerifyCodeUtil.outputImage(w, h, response.getOutputStream(), verifyCode);
	}
}
