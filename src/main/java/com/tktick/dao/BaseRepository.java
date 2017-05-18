package com.tktick.dao;

import java.io.Serializable;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.PagingAndSortingRepository;
/**
 * jpa基础dao层
 * JpaSpecificationExecutor 方便分页
 * @author user
 *
 */
@NoRepositoryBean //如果不使用此注解，会报 Not an managed type: class java.lang.Object 错误
public interface BaseRepository<T, ID extends Serializable> extends PagingAndSortingRepository<T, ID>, JpaSpecificationExecutor<T> {
	
}
