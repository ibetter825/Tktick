package com.tktick.controller.web;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import com.tktick.annotation.Permission;
import com.tktick.annotation.Validator;
import com.tktick.bean.entity.TkArticle;
import com.tktick.bean.model.ResultModel;
import com.tktick.service.TkArticleService;
import com.tktick.utils.DateUtil;

/**
 * 文章类
 * @author user
 *
 */
@RestController
@RequestMapping("/art")
public class ArticleController extends WebBaseController {
	
	@Autowired
	private TkArticleService articleService;
	
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
	
	/**
	 * 保存新的文章
	 * @return
	 */
	@RequestMapping("/save.json")
	@Permission
	@Validator
	public ResultModel save(@Valid TkArticle article, BindingResult binding){
		ResultModel model = new ResultModel();
		
		long time = DateUtil.getDateByTime();
		article.setAddTime(time);
		article.setUser(getCurrentUser());
		
		articleService.saveArticle(article);
		System.err.println(article.getArtId());
		return model;
	}
}
