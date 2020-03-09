package com.codepresso.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codepresso.domain.FollowVO;
import com.codepresso.domain.ResponseData;
import com.codepresso.service.FollowService;

@RestController
@RequestMapping("/follow")
public class FollowController {

	private static final Logger logger = LoggerFactory.getLogger(FollowController.class);

	@Autowired(required=true)
	private FollowService followService;

	@PostMapping("")
	public ResponseData followUser(@RequestBody FollowVO followeeIdInVO,
			@CookieValue(value = "accesstoken", required = false) String accesstoken) throws Exception {
		logger.info("call followUser()");
		return followService.followUser(followeeIdInVO, accesstoken);
	}

	@DeleteMapping("")
	public ResponseData unfollowUser(@RequestBody FollowVO followeeId,
			@CookieValue(value = "accesstoken", required = false) String accesstoken) throws Exception {
		logger.info("call unfollowUser()");
		return followService.unfollowUser(followeeId, accesstoken);
	}

}
