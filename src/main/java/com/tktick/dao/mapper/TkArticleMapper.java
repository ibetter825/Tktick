package com.tktick.dao.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import com.tktick.bean.entity.TkArticle;
import com.tktick.bean.rq.PagerRq;
import com.tktick.dao.BaseMapper;

public interface TkArticleMapper extends BaseMapper<TkArticle> {
	/**
	 * 根据参数查询文章并设置将结果封装为map集合
	 * @param map
	 * @return
	 */
	public List<Map<?, ?>> selectListByRq(Map<String, Object> rq);
	/**
	 * 根据查询条件与分页查询数据
	 * @param rq
	 * @param pager
	 * @return
	 */
	public List<Map<?, ?>> selectListByRqAndPager(@Param("rq") Map<String, Object> rq, @Param("pager") PagerRq pager);
	/**
	 * 根据id查询状态不为-1的文章
	 * @param id
	 * @param state
	 * @return
	 */
	@Select("select id, user_id from tk_article where id = #{id} and art_state <> -1")
	@Results(id = "articleResultMap", value = {
			  @Result(property = "id", column = "id", id = true),
			  @Result(property = "userId", column = "user_id")
	})
	public TkArticle selectOneById(Long id);
	/**
	 * 根据ID查询map
	 * @param id
	 * @return
	 */
	public Map<?, ?> selectOneByIdForMap(Long id);
	/**
	 * 查询文章的前n条评论，以及每条评论的前五条回复
	 * 参数包括: id文章id page页码  size每页数据大小 start: (page-1)*size
	 * @param params
	 * @return
	 */
	public List<Map<?, ?>> selectComtsAndReplies(Map<?, ?> params);
}
