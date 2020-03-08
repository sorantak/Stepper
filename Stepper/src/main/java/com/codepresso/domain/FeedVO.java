package com.codepresso.domain;

import java.sql.Date;

import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data
public class FeedVO {
	
	private Long userId;
	private Long followeeId;
	private Long postId;
	private Date createdAt;

}
