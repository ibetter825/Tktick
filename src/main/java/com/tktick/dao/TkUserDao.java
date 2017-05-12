package com.tktick.dao;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.tktick.model.entity.TkUser;
/**
 * JpaSpecificationExecutor 方便分页
 * @author user
 *
 */
@Repository
public interface TkUserDao extends PagingAndSortingRepository<TkUser, Long>, JpaSpecificationExecutor<TkUser> {
	
	@Query("from TkUser t where name = :username")
	public TkUser selectUserByUsername(@Param(value = "username") String username);
}
