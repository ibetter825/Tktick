package com.tktick.controller.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.tktick.model.entity.TkUser;
import com.tktick.service.TkUserService;

/**
 * 首页控制器
 * @author user
 *
 */
@RestController
public class IndexController extends WebBaseController {
	
	@Autowired
	private TkUserService userService;
	
	@RequestMapping("/")
	public ModelAndView index(){
		return new ModelAndView("web/index");
	}
	
	@RequestMapping("/get/{name}")
	public TkUser get(@PathVariable(value = "name") String name){
		return userService.getTkUserByUsername(name);
	}
}
