package com.codepresso.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.codepresso.domain.FeedVO;
import com.codepresso.domain.FollowVO;
import com.codepresso.domain.PostAndUserVO;
import com.codepresso.domain.PostVO;
import com.codepresso.domain.ResponseData;
import com.codepresso.domain.TokenVO;
import com.codepresso.domain.UserVO;
import com.codepresso.repository.FeedDAO;
import com.codepresso.repository.FollowDAO;
import com.codepresso.repository.PostDAO;
import com.codepresso.repository.UserDAO;

@Service
public class FollowServiceImpl {

	private static final Logger logger = LoggerFactory.getLogger(FollowServiceImpl.class);

	@Autowired
	ResponseData responseData;

	@Autowired
	FollowDAO followDAO;

	@Autowired
	UserDAO userDAO;

	@Autowired
	UserVO userVO;

	@Autowired
	TokenVO tokenVO;

	@Autowired
	FollowVO followVO;

	@Autowired
	PostAndUserVO postAndUserVO;

	@Autowired
	PostDAO postDAO;
	
	@Autowired
	FeedVO feedVO;
	
	@Autowired
	FeedDAO feedDAO;
	
	@Autowired
	PostVO postVO;
	
	public ResponseData followUser(FollowVO followeeIdInVO, String accesstoken) throws Exception {
		logger.info("call followUser()");

		try {
			TokenVO followerByToken = userDAO.viewUserByToken(accesstoken);
			logger.info("follower by token: " + followerByToken);

			Long followerId = followerByToken.getUserId();
			logger.info("follower id: " + followerId);

			followeeIdInVO.setFollowerId(followerId);
			logger.info(followeeIdInVO.toString());
			followDAO.followUser(followeeIdInVO);

			responseData.setCode(HttpStatus.OK);
			responseData.setMessage("OK");
			responseData.setData("SUCCESS");
			return responseData;
		} catch (Exception e) {
			e.printStackTrace();
			responseData.setCode(HttpStatus.INTERNAL_SERVER_ERROR);
			responseData.setMessage("INTERNAL_SERVER_ERROR");
			responseData.setData("FAIL");
			return responseData;
		}

	}

	public ResponseData unfollowUser(FollowVO followeeId, String accesstoken) throws Exception {
		logger.info("call unfollowUser()");

		try {
			TokenVO followerByToken = userDAO.viewUserByToken(accesstoken);
			logger.info("follower by token: " + followerByToken);

			Long followerId = followerByToken.getUserId();
			logger.info("follower id: " + followerId);

			followeeId.setFollowerId(followerId);
			logger.info(followeeId.toString());
			followDAO.unfollowUser(followeeId);

			responseData.setCode(HttpStatus.OK);
			responseData.setMessage("OK");
			responseData.setData("SUCCESS");
			return responseData;
		} catch (Exception e) {
			e.printStackTrace();
			responseData.setCode(HttpStatus.INTERNAL_SERVER_ERROR);
			responseData.setMessage("INTERNAL_SERVER_ERROR");
			responseData.setData("FAIL");
			return responseData;
		}

	}

}
