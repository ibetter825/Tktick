package com.tktick.dao.mapper;

import java.util.List;
import java.util.Map;

import com.tktick.bean.entity.TkHome;
import com.tktick.dao.BaseMapper;

public interface TkHomeMapper extends BaseMapper<TkHome> {
	
	/**
	 * 根据参数查询首页数据
	 * @param rq
	 * @return
	 */
	public List<Map<?, ?>> selectListForMapByRq(Map<String, Object> rq);
}
