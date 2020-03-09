package com.codepresso.repository;

import java.util.List;

import com.codepresso.domain.FeedVO;

public interface FeedDAO {

	public int insertFeed(FeedVO feedVO) throws Exception;

	public List<FeedVO> findFolloweeByUser(Long userId) throws Exception;

	public int deleteFeedByPostId(Long id) throws Exception;

}
