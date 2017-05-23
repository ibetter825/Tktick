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
		
		article.setArtTitle("张掖");
		article.setArtCont("张掖的丹霞地貌,其震撼无法用文字形容。其气势之磅礴、场面之壮观、造型之奇特、色彩之斑斓，真可谓是大自然的鬼斧神工，令人惊叹。她不仅具有一般丹霞的奇、险，而且更美的在于色.如诗似画的丹霞地貌是如何形成的？科学地说，它是漫长历史时期地壳运动的产物，是大自然鬼斧神工的杰作。丹霞地质构造是岩石堆积形成的，它是指红色砂岩经长期风化剥离和流水侵蚀，加之特殊的地质结构、气候变化以及风力等自然环境的影响，形成孤立的山峰和陡峭的奇岩怪石，主要发育于侏罗纪至第三纪的水平或缓倾的红色地层中，是巨厚红色砂、砾岩层中沿垂直节理发育的各种丹霞奇峰的总称。");
		long time = DateUtil.getDateByTime();
		article.setAddTime(time);
		article.setUserId(getCurrentUser().getUserId());
		article.setArtAuth((short) 1);
		article.setArtState((short) 1);
		article.setEditTime(time);
		
		articleService.saveArticle(article);
		System.err.println(article.getArtId());
		return model;
	}
}
