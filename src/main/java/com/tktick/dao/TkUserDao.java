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
	@Query("from TkUser t where userName = :userName and userState <> -1")
	public TkUser selectUserByUsername(@Param(value = "userName") String userName);
	
	@Query("from TkUser t where userPhone = :userPhone and userState <> -1")
	public TkUser selectUserByPhone(@Param(value = "userPhone") Integer userPhone);
	
	@Query("from TkUser t where userEmail = :userEmail and userState <> -1")
	public TkUser selectUserByEmail(@Param(value = "userEmail") String userEmail);
}
