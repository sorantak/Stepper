package com.codepresso.service;

import com.codepresso.domain.ResponseData;
import com.codepresso.domain.UserVO;

public interface UserService {

	public ResponseData findAllUsersList();
	
	public ResponseData findUserById(Long id);
	
	public ResponseData saveUser(UserVO userVO);
	
	public ResponseData FindUserByToken(UserVO userVO);
	
}
