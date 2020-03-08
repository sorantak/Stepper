package com.codepresso.domain;

import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data
public class ResponseData {

	private int code;
	private String message;
	private Object data;
	
}
