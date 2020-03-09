package com.codepresso.service;

import com.codepresso.domain.ResponseData;
import com.codepresso.domain.UserVO;

public interface UserService {

	public ResponseData findAllUsersList() throws Exception;
	
	public ResponseData findUserById(Long id) throws Exception;
	
	public ResponseData saveUser(UserVO userVO) throws Exception;
	
	public ResponseData FindUserByToken(UserVO userVO) throws Exception;
	
}
