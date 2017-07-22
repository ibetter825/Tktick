package com.tktick.service;

import java.util.List;
import java.util.Map;

import com.tktick.bean.entity.TkDict;
import com.tktick.bean.model.TreeModel;
import com.tktick.bean.rq.QueryRq;

public interface TkDictService {
	/**
	 * 保存字典
	 * @param dict
	 * @return
	 */
	public boolean save(TkDict dict);
	/**
	 * 查询字典列表
	 * @param rq
	 * @return
	 */
	public List<Map<?, ?>> queryForMapList(QueryRq rq);
	/**
	 * 根据父菜单查询字典
	 * @param fno
	 * @return
	 */
	public List<TreeModel> queryForTreeListByFno(String fno);
}
