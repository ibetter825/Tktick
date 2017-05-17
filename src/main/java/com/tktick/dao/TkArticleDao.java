package com.tktick.dao;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import com.tktick.bean.entity.TkArticle;
/**
 * JpaSpecificationExecutor 方便分页
 * @author user
 *
 */
@Repository
public interface TkArticleDao extends PagingAndSortingRepository<TkArticle, Long>, JpaSpecificationExecutor<TkArticle> {
	
}
