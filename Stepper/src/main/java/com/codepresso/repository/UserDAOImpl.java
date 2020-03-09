package com.codepresso.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.codepresso.domain.TokenVO;
import com.codepresso.domain.UserVO;

@Repository
public class UserDAOImpl {

	private static final Logger logger = LoggerFactory.getLogger(UserDAOImpl.class);
	
	@Autowired
	private SqlSession sqlSession; 
	
	private static final String Namespace = "mappers.user";
	
	public List<UserVO> findAllUsersList() throws Exception {
		logger.info("call findAllUsersList() method in UserDAO");
		List<UserVO> resultList = sqlSession.selectList(Namespace + ".findAllUsersList");
		return resultList;
	}
	
	public UserVO findUserById(Long id) throws Exception {
		logger.info("call findUserById() method in UserDAO");
		UserVO result = sqlSession.selectOne(Namespace + ".findUserById", id);
		return result;
	}
	
	public int saveUser(UserVO userVO) throws Exception {
		logger.info("call saveUser() method in UserDAO");
		int result = sqlSession.insert(Namespace + ".saveUser", userVO);
		return result;
	}
	
	public UserVO logInByUser(UserVO userVO) throws Exception {
		logger.info("call loginByUser() method in UserDAO");
		UserVO result = sqlSession.selectOne(Namespace + ".logInByUser", userVO);
		return result;
	}
	
	public int createToken(TokenVO tokenVO) throws Exception {
		logger.info("call createToken() method in UserDAO");
		int result = sqlSession.insert(Namespace + ".createToken", tokenVO);
		return result;
	}
	
	public TokenVO viewUserByToken(String token) throws Exception {
		logger.info("call viewUserByToken() method in UserDAO");
		TokenVO result = sqlSession.selectOne(Namespace + ".viewUserByToken", token);
		return result;
	}
	
}
