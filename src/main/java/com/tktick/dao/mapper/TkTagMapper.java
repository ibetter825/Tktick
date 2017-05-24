package com.tktick.dao.mapper;

import org.apache.ibatis.annotations.Select;

import com.tktick.bean.entity.TkTag;
import com.tktick.dao.BaseMapper;

public interface TkTagMapper extends BaseMapper<TkTag> {
	@Select("SELECT id, tag_nm, art_num FROM tk_tag WHERE tag_nm = #{name}")
	public TkTag selectByName(String name);
}
