package com.tktick.controller.web;

import java.util.Map;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.google.common.collect.Maps;
import com.tktick.annotation.Permission;
import com.tktick.annotation.Validator;
import com.tktick.bean.entity.TkArticle;
import com.tktick.bean.entity.TkDeliver;
import com.tktick.bean.enums.ResultMessageEnum;
import com.tktick.bean.model.PageModel;
import com.tktick.bean.model.ResultModel;
import com.tktick.bean.rq.PagerRq;
import com.tktick.bean.rq.QueryRq;
import com.tktick.service.TkArticleService;
import com.tktick.service.TkDeliverService;
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
	@Autowired
	private TkDeliverService deliverService;
	
	@RequestMapping("/{id}.html")
	public ModelAndView index(@PathVariable("id") Long id){
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
		
		article.setArtTitle("6月起，四川这些地方够你玩整年！美的一塌糊涂…");
		article.setArtCont("入夏之后中国西南的蜀地切换成天堂的样子一朵花、一片云、一座山、一湖水都美的像一幅幅世外桃源画卷6月开始的四川，足够你玩一整年碧草蓝天、七色花海、弯弯河流，这里就是俄木塘，每年六七月间，方圆万亩草原是一片花的海洋美不胜收，因此被誉为“最美的草原花海”。*推荐自驾路线：成都→蜀西路→都汶高速→G213→S301→九寨沟。松坪沟是镶嵌在成都至九寨沟干线上的一颗明珠，海子、森林、群山、民俗风情让人恋恋不舍。同一水面呈现墨绿、深蓝、翡翠色彩，阳光照射林木，群峰倒映，水色变幻，令人如痴如醉。松坪沟有九景：芳草海、鱼儿寨海、上白蜡海、下白蜡海、珍珠瀑、白石海、墨海、五彩池、长海，景景撩人，别有洞天！*推荐自驾路线：成都(成灌)→都江堰(都汶)→汶川→茂县→\"6回头\"的第一个弯倒左手→松坪沟景区。有人说，稻城亚丁是“水蓝色星球上的最后一片净土”，这里蓝色的海子，让人一见倾心；纯白的雪山，遗世绝美；翠绿的草原上小溪划过,春意盎然!亚丁的每一种色彩都是纯粹的，每一处景色都是绝美的。美国地理学家约瑟夫洛克曾于1928年美国《国家地理》上说“世界上还有什么地方，景致如此完美，等待着探险家、摄影家们。这真是美丽的香格里拉”。*推荐自驾路线：成都→都江堰→映秀→四姑娘山→雅江→理塘→稻城亚丁。“奶子沟”距成都310公里，在藏语里是美丽富饶、幸福安宁之意。奶子沟八十里彩林风情谷因身处深谷独享清幽雅静的奶子沟而得名，又以美甲天下的彩林世界而闻名，洋洋洒洒长达八十里，蔚为壮观。*推荐自驾路线：成都→汶川→茂县→卡龙沟→黑水县。11月的光雾山，漫山红叶如火如荼，层林尽染、万山红遍、五彩缤纷，曾被誉为中国红叶第一山，也是中国最好的彩林之一。光雾山红叶有面积大、色彩多、周期长等几大特点，800多平方公里的景区有500多平方公里为红叶景观带，而景观带又分蓝、绿、黄、橙、红等色调，红叶周期可达一个月，从五彩斑斓看到漫山红透，颇为壮观。*推荐自驾路线：成都→广元→汉中→光雾山。米仓山在四川省和山西省边境，森林公园面积达401.6平方公里，其中就有300多平方公里几种连片的红叶景观，07年被评为“中国红叶之乡”。同光雾山国家重点风景名胜区相邻。*推荐自驾路线：成都→广元→汉中→米仓山。12月海螺沟贡嘎雪峰脚下的海螺沟，是青藏高原东缘的极高山地，以低海拔现代冰川著称于世。海螺沟有五绝：日照金山、冰川倾泄、雪谷温泉、原始森林和康巴藏族风情。冬天的海螺沟雪花漫天，这里有温泉数十处，可来此洗温泉浴赏雪景，实在美妙。*推荐自驾路线：成都→成雅高速→雅安→雅西高速→石棉→海螺沟。大美四川今年就照着一个个去走遍吧");
		long time = DateUtil.getDateByTime();
		article.setAddTime(time);
		article.setUserId(getCurrentUser().getUserId());
		article.setArtAuth((short) 1);
		article.setArtState((short) 1);
		article.setEditTime(time);
		
		articleService.save(article);
		System.err.println(article.getId());
		return model;
	}
	
	/**
	 * 分页查询文章
	 * @param page
	 * @param query
	 * @return
	 */
	@RequestMapping("/list.json")
	public PageModel list(PagerRq page, QueryRq query){
		/*
		 * 查询排序提供两种方法
		 * 1, grid插件使用page中的sort, order字段排序
		 * 2, 自定义查询使用query对象中的方法
		*/
		Page<Map<?, ?>> pager = PageHelper.startPage(page.getPage(), page.getSize(), false);//分页插件
		PageHelper.orderBy(page.getOrder());
		articleService.queryForMapList(query);
		return new PageModel(pager);
	}
	
	/**
	 * 软删除文章
	 * @param id
	 * @return
	 */
	@RequestMapping(path = "/del/{id}.json", method = RequestMethod.POST)
	@Permission
	public ResultModel del(@PathVariable("id") Long id){
		//只能文章的作者才能删除
		TkArticle article = articleService.query(id, true);
		if(article == null)
			return new ResultModel(ResultMessageEnum.DATA_NOT_EXISTS);
		Integer uid = getCurrentUser().getUserId();
		Integer aid = article.getUserId();
		if(!uid.equals(aid))//不是文章作者
			return new ResultModel(ResultMessageEnum.OPTION_FORBIDDEN);
		article.setUserId(null);
		article.setArtState((short) -1);
		boolean res = articleService.modify(article);
		if(res)
			return new ResultModel();
		else
			return new ResultModel(ResultMessageEnum.OPTION_EXCEPTION);
	}
	
	/**
	 * 根据id分页查询评论以及恢复
	 * @param id 文章id
	 * @param page 页码
	 * @param size 每页大小
	 * @return
	 */
	@RequestMapping("/comts/{id}-{page}-{size}.json")
	public ResultModel comts(@PathVariable("id") Long id,
							 @PathVariable("page") Integer page,
							 @PathVariable("size") Integer size){
		Map<String, Object> params = Maps.newHashMap();
		params.put("id", id);
		params.put("page", page == null ? 0 : page);
		params.put("size", size == null ? 0 : size);
		params.put("start", (page - 1) * size);
		ResultModel model = new ResultModel();
		model.getData().put("records", articleService.queryComtsAndReplies(params));
		return model;
	}
	
	/**
	 * 投递文章
	 * @param setId 合集id
	 * @param artId 文章id
	 * @return
	 */
	@RequestMapping("/deli/{setId}/{artId}.json")
	public ResultModel deliver(@PathVariable("setId") Integer setId, @PathVariable("artId") Long artId){
		TkDeliver deliver = new TkDeliver();
		deliver.setArtId(artId);
		deliver.setSetId(setId);
		deliver.setDverState((short) 0);
		deliver.setDverTime(DateUtil.getDateByTime());
		ResultModel model = new ResultModel();
		if(!deliverService.save(deliver))
			model = new ResultModel(ResultMessageEnum.OPTION_EXCEPTION);
		return model;
	}
}
