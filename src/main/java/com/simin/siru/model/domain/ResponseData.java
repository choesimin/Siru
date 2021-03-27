package com.simin.siru.model.domain;

import lombok.Data;

@Data
public class ResponseData {
	
	private String message;
	private String url;
	private int code;
	private Object object;

}
