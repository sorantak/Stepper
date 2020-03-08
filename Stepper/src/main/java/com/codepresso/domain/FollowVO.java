package com.codepresso.domain;

import java.sql.Date;

import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data
public class FollowVO {

	private Long followeeId;
	private Long followerId;
	private Date createdAt;
	
}
