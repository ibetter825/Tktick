package com.tktick.dao.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.tktick.bean.entity.TkUser;
import com.tktick.dao.BaseRepository;

/**
 * JpaSpecificationExecutor 方便分页
 * @author user
 *
 */
@Repository
public interface TkUserRepository extends BaseRepository<TkUser, Integer> {
	@Query("from TkUser t where userName = :userName and userState <> -1")
	public TkUser selectUserByUsername(@Param(value = "userName") String userName);
	
	@Query("from TkUser t where userPhone = :userPhone and userState <> -1")
	public TkUser selectUserByPhone(@Param(value = "userPhone") Long userPhone);
	
	@Query("from TkUser t where userEmail = :userEmail and userState <> -1")
	public TkUser selectUserByEmail(@Param(value = "userEmail") String userEmail);
}
