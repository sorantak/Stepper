package com.codepresso.repository;

import java.util.List;

import com.codepresso.domain.TokenVO;
import com.codepresso.domain.UserVO;

public interface UserDAO {

	public List<UserVO> findAllUsersList();
	
	public UserVO findUserById(Long id);
	
	public int saveUser(UserVO userVO);
	
	public UserVO logInByUser(UserVO userVO);

	public int createToken(TokenVO tokenVO);
	
	public TokenVO viewUserByToken(String token);

}
