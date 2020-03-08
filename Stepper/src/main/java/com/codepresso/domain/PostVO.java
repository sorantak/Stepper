package com.codepresso.domain;

import java.sql.Date;

import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data
public class PostVO {

	private Long id;
	private Long userId;
	private String title;
	private String content;
	private Date createdAt;
	
}
