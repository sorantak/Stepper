package com.codepresso.repository;

import java.util.List;

import com.codepresso.domain.TokenVO;
import com.codepresso.domain.UserVO;

public interface UserDAO {

	public List<UserVO> findAllUsersList() throws Exception;
	
	public UserVO findUserById(Long id) throws Exception;
	
	public int saveUser(UserVO userVO) throws Exception;
	
	public UserVO logInByUser(UserVO userVO) throws Exception;

	public int createToken(TokenVO tokenVO) throws Exception;
	
	public TokenVO viewUserByToken(String token) throws Exception;

}
