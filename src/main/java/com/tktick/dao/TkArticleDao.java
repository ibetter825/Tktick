package com.tktick.dao;

import org.springframework.stereotype.Repository;
import com.tktick.bean.entity.TkArticle;
/**
 * JpaSpecificationExecutor 方便分页
 * @author user
 *
 */
@Repository
public interface TkArticleDao extends BaseDao<TkArticle, Long> {
	
}
