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
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public Long getFolloweeId() {
		return followeeId;
	}
	public void setFolloweeId(Long followeeId) {
		this.followeeId = followeeId;
	}
	public Long getPostId() {
		return postId;
	}
	public void setPostId(Long postId) {
		this.postId = postId;
	}
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	
}
