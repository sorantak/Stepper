package com.codepresso.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.codepresso.domain.FeedVO;

@Repository
public class FeedDAOImpl {

	private static final Logger logger = LoggerFactory.getLogger(FeedDAOImpl.class);
	
	@Autowired
	private SqlSession sqlSession;

	private static final String Namespace = "com.myspring.mysns.mappers.feed";

	public int insertFeed(FeedVO feedVO) throws Exception {
		logger.info("call insertFeed()");
		
		int result = sqlSession.insert(Namespace + ".insertFeed", feedVO);

		return result;
	}

	public List<FeedVO> findFolloweeByUser(Long userId) throws Exception {
		logger.info("call findFolloweeByUser()");
		
		List<FeedVO> result = sqlSession.selectList(Namespace + ".findFolloweeByUser", userId);

		return result;
	}

	public int deleteFeedByPostId(Long id) throws Exception {
		logger.info("call deleteFeedByPostId()");
		
		int result = sqlSession.insert(Namespace + ".deleteFeedByPostId", id);

		return result;
	}
}
