package com.codepresso.domain;

import java.sql.Date;

import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data
public class PostAndUserVO {

	private Long id;
	private Long userId;
	private String title;
	private String content;
	private Date createdAt;
	private UserVO User;
	
}
