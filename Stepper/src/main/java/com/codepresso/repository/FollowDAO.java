package com.codepresso.repository;

import java.util.List;

import com.codepresso.domain.FollowVO;

public interface FollowDAO {

	public int followUser(FollowVO followeeIdInVO) throws Exception;

	public int unfollowUser(FollowVO followeeId) throws Exception;
	
	public List<FollowVO> findFollowersByFollowee(Long followeeId) throws Exception;

}
