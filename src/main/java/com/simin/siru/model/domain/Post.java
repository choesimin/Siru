package com.simin.siru.model.domain;

import lombok.Data;

@Data
public class Post {
	private int post_id;
	private int member_id;
	private Member member;
	private String title;
	private String content;
	private String date;
	
}
