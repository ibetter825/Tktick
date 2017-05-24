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
	 * @throws InterruptedException 
	 */
	@RequestMapping("/save.json")
	@Permission
	@Validator
	public ResultModel save(@Valid TkArticle article, BindingResult binding) throws InterruptedException{
		ResultModel model = new ResultModel();
		
		article.setArtTitle("去清迈跑马拉松：和突突车抢道，一场泰北的马拉松大冒险");
		article.setArtCont("时至今日，仍有争论当年邓丽君小姐的《小城故事》，到底是哪个“小城”,作为主题曲，电影<小城故事>的拍摄地在彰化鹿港；影片讲的则是苗栗县三义，作词作曲者也特地去当地采风以完成创作；而邓丽君的拥趸们坚信清迈才是最符合的小城，“…看似一幅画/听像一首歌/人生境界真善美这里已包括”唱的一定是清迈，不然为何走过那么多地方，邓丽君最爱的还是清迈、时不时故地重游呢？（1995年4月，邓丽君故地重游，原本打算住几天返回法国，不料5月8日突发哮喘，在酒店房外的走廊辞世，享年42岁。邓丽君在清迈一直住美萍酒店，如今当年她常住的那间房间照常营业，无人入住时则可参观游览。抵达清迈第二天中午我们便去美萍酒店吃了顿午饭。）今年恰逢清迈建城720年，清迈马拉松也正好走完第一个十年。比赛和这座小城一样，故事很多。如果说东京马拉松像冬日里的寿喜锅，内容温暖又丰富，那清迈马拉松就是一碗冬阴功了，味道浓郁辛辣。穿古城墙夜奔离城、沿着高低斜坡公路体验清迈郊区风情、在反复的折返里和汽车争分夺秒、辛苦完赛后的补给却出人意料的丰盛……喜欢的人乐在其中，不对味的就只有叫苦连天了。在离开清迈时回忆比赛，评价变得非常困难。赛事的组织很“泰国”，组织上的漏洞明显，但参赛者可以在里面找到很多乐趣。对比国内不少可以说是戒备森严的马拉松，跑清迈有点像学生时代偷偷去网吧的快感，这和正儿八经在家玩电脑完全两种体验。");
		long time = DateUtil.getDateByTime();
		article.setAddTime(time);
		article.setUserId(getCurrentUser().getUserId());
		article.setArtAuth((short) 1);
		article.setArtState((short) 1);
		article.setEditTime(time);
		
		articleService.saveArticle(article);
		System.err.println(article.getId());
		return model;
	}
}
