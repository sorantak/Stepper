package com.codepresso.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.codepresso.domain.FollowVO;

@Repository
public class FollowDAOImpl implements FollowDAO {

	private static final Logger logger = LoggerFactory.getLogger(FollowDAOImpl.class);

	@Autowired
	private SqlSession sqlSession;

	private static final String Namespace = "mybatis.mappers.follow";

	@Override
	public int followUser(FollowVO followeeIdInVO) throws Exception {
		logger.info("call followUser()");

		int result = sqlSession.insert(Namespace + ".followUser", followeeIdInVO);

		return result;
	}

	@Override
	public int unfollowUser(FollowVO followeeId) throws Exception {
		logger.info("call unfollowUser()");

		int result = sqlSession.insert(Namespace + ".unfollowUser", followeeId);

		return result;
	}

	@Override
	public List<FollowVO> findFollowersByFollowee(Long followeeId) throws Exception {
		logger.info("call findFollowersByFollowee()");
		
		List<FollowVO> result = sqlSession.selectList(Namespace + ".findFollowersByFollowee", followeeId);
		
		return result;
	}
	
}
