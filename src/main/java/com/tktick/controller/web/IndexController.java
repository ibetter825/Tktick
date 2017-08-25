package com.tktick.controller.web;

import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import com.google.common.collect.Maps;
import com.tktick.bean.entity.TkHome;
import com.tktick.bean.entity.TkUser;
import com.tktick.bean.model.TreeModel;
import com.tktick.bean.rq.PagerRq;
import com.tktick.bean.rq.QueryRq;
import com.tktick.service.TkArticleService;
import com.tktick.service.TkDictService;
import com.tktick.service.TkHomeService;
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
	@Autowired
	private TkDictService dictService;
	@Autowired
	private TkHomeService homeService;
	@Autowired
	private TkArticleService articleService;
	
	@RequestMapping("/")
	public ModelAndView index(){
		//首页的内容大部分是后台专门的一张表来管理
		List<TreeModel> navs = dictService.queryForTreeListByFno("D001");//导航条
		Map<String, List<?>> model = Maps.newHashMap();
		//导航条
		model.put("navs", navs);
		//轮播图（内容为测评）, 专题4个, 合集列表
		Map<String, List<TkHome>> homeConts = homeService.queryHomeCont();
		//最新的文章
		articleService.queryForMapList(new QueryRq(), new PagerRq().setSize(10));
		return new ModelAndView("web/index", model);
	}
	
	@RequestMapping("/get/{name}")
	public TkUser get(@PathVariable(value = "name") String name){
		return userService.queryByUsername(name);
	}
}
