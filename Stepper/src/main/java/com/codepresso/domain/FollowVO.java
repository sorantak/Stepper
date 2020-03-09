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
	public Long getFolloweeId() {
		return followeeId;
	}
	public void setFolloweeId(Long followeeId) {
		this.followeeId = followeeId;
	}
	public Long getFollowerId() {
		return followerId;
	}
	public void setFollowerId(Long followerId) {
		this.followerId = followerId;
	}
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	
}
