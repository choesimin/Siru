package com.simin.siru.model.domain;

import lombok.Data;

@Data
public class Story {
	private int story_id;
	private int member_id;
	private Member member;
	private String title;
	private String content;
	private String date;
	
}
