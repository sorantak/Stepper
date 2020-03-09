package com.codepresso.service;

import com.codepresso.domain.FollowVO;
import com.codepresso.domain.ResponseData;

public interface FollowService {

	public ResponseData followUser(FollowVO followeeIdInVO, String accesstoken) throws Exception;

	public ResponseData unfollowUser(FollowVO followeeId, String accesstoken) throws Exception;

}
