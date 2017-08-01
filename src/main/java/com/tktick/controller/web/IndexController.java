package com.tktick.controller.web;

import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import com.google.common.collect.Maps;
import com.tktick.bean.entity.TkUser;
import com.tktick.bean.model.TreeModel;
import com.tktick.service.TkDictService;
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
	
	@RequestMapping("/")
	public ModelAndView index(){
		List<TreeModel> navs = dictService.queryForTreeListByFno("D001");//导航条
		Map<String, List<?>> model = Maps.newHashMap();
		model.put("navs", navs);
		//首页的内容大部分是后台专门的一张表来管理
		//轮播图（内容为测评）
		//专题4个
		//合集列表
		//最新的文章
		return new ModelAndView("web/index", model);
	}
	
	@RequestMapping("/get/{name}")
	public TkUser get(@PathVariable(value = "name") String name){
		return userService.queryByUsername(name);
	}
}
