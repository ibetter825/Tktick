package com.tktick.dao.repository;

import org.springframework.stereotype.Repository;
import com.tktick.bean.entity.TkArticle;
import com.tktick.dao.BaseRepository;
/**
 * JpaSpecificationExecutor 方便分页
 * @author user
 *
 */
@Repository
public interface TkArticleRepository extends BaseRepository<TkArticle, Long> {
	
}
