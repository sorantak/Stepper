package com.codepresso.service;

import com.codepresso.domain.FollowVO;
import com.codepresso.domain.ResponseData;

public interface FollowService {

	public ResponseData followUser(FollowVO followeeIdInVO, String accesstoken);

	public ResponseData unfollowUser(FollowVO followeeId, String accesstoken);

}
