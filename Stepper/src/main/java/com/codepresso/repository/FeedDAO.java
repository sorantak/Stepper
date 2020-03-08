package com.codepresso.repository;

import java.util.List;

import com.codepresso.domain.FeedVO;

public interface FeedDAO {

	public int insertFeed(FeedVO feedVO);

	public List<FeedVO> findFolloweeByUser(Long userId);

	public int deleteFeedByPostId(Long id);

}
