package com.tktick.dao.repository;

import org.springframework.stereotype.Repository;

import com.tktick.bean.entity.TkTag;
import com.tktick.dao.BaseRepository;

@Repository
public interface TkTagRepository extends BaseRepository<TkTag, Integer> {
	
}
