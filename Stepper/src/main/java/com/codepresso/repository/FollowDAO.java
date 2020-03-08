package com.codepresso.repository;

import java.util.List;

import com.codepresso.domain.FollowVO;

public interface FollowDAO {

	public int followUser(FollowVO followeeIdInVO);

	public int unfollowUser(FollowVO followeeId);
	
	public List<FollowVO> findFollowersByFollowee(Long followeeId);

}
