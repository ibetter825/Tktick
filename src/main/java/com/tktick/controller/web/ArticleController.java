package com.tktick.controller.web;

import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.tktick.annotation.Permission;

/**
 * 文章类
 * @author user
 *
 */
@RestController
@RequestMapping("/art")
@Scope("prototype")
public class ArticleController extends WebBaseController {
	
	@RequestMapping("/{id}.html")
	public ModelAndView index(@PathVariable("id") Long artId){
		return new ModelAndView("web/article");
	}
	
	/**
	 * 跳转到写文章页面
	 * @return
	 */
	@RequestMapping("/write.html")
	@Permission
	public ModelAndView write(){
		return new ModelAndView("web/write");
	}
}
