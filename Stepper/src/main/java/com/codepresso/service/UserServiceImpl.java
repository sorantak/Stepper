package com.codepresso.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.codepresso.domain.FollowVO;
import com.codepresso.domain.ResponseData;
import com.codepresso.domain.TokenVO;
import com.codepresso.domain.UserVO;
import com.codepresso.repository.FollowDAO;
import com.codepresso.repository.UserDAO;
import com.codepresso.util.RandomToken;

@Service
public class UserServiceImpl {

	private static final Logger logger = LoggerFactory.getLogger(UserService.class);

	@Autowired
	private UserDAO userDAO;

	@Autowired
	ResponseData responseData;

	@Autowired
	UserVO userVO;

	@Autowired
	TokenVO tokenVO;

	@Autowired
	FollowVO followVO;

	@Autowired
	FollowDAO followDAO;

	public ResponseData findAllUsersList() throws Exception {
		logger.info("call findAllUsersList() method in UserService");
		List<UserVO> userList = userDAO.findAllUsersList();

		responseData.setCode(HttpStatus.OK);
		responseData.setMessage("SUCCESS");
		responseData.setData(userList);

		return responseData;
	}

	public ResponseData findUserById(Long id) throws Exception {
		logger.info("call findUserById() method in UserService");

		userVO = userDAO.findUserById(id);

		responseData.setCode(HttpStatus.OK);
		responseData.setMessage("SUCCESS");
		responseData.setData(userVO);

		return responseData;
	}

	public ResponseData saveUser(UserVO userVO) throws Exception {
		logger.info("call saveUser() method in UserService");

		userDAO.saveUser(userVO);

		Long id = userVO.getId();
		userVO = userDAO.findUserById(id);

		responseData.setCode(HttpStatus.OK);
		responseData.setMessage("SUCCESS");
		responseData.setData(userVO);

		return responseData;
	}

	public ResponseData FindUserByToken(UserVO userVO) throws Exception {
		logger.info("call FindUserByToken() method in UserService");
		
		UserVO user = userDAO.logInByUser(userVO);
		Long id = user.getId();

		StringBuffer token = RandomToken.createToken();

		String tokenToString = token.toString();

		tokenVO.setUserId(id);
		tokenVO.setToken(tokenToString);

		userDAO.createToken(tokenVO);

		TokenVO resultToken = userDAO.viewUserByToken(tokenToString);
		
		logger.info("token: " + tokenToString);

		// 로그인할 때 나 자신을 follow
		try {
			followVO.setFolloweeId(id);
			followVO.setFollowerId(id);
			followDAO.followUser(followVO);
			
			responseData.setCode(HttpStatus.OK);
			responseData.setMessage("SUCCESS");
			responseData.setData(tokenVO);

			return responseData;
		} catch (Exception e) {
			logger.info("나 자신 follow 에러 예외처리");
			e.printStackTrace();
			
			responseData.setCode(HttpStatus.OK);
			responseData.setMessage("SUCCESS");
			responseData.setData(resultToken);
			return responseData;
		}
	}
	
}
