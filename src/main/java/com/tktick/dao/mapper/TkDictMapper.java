package com.tktick.dao.mapper;

import java.util.List;
import java.util.Map;

import com.tktick.bean.entity.TkDict;
import com.tktick.dao.BaseMapper;

public interface TkDictMapper extends BaseMapper<TkDict> {
	/**
	 * 根据参数查询字典并设置将结果封装为map集合
	 * @param rq
	 * @return
	 */
	public List<Map<?, ?>> selectListByRq(Map<String, Object> rq);
	/**
	 * 根据父级字典编码查询所有的子字典
	 * @param fno
	 * @return
	 */
	public List<TkDict> selectListByFno(String fno);
}
