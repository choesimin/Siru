package com.simin.siru.model.domain;

import lombok.Data;

@Data
public class Comment {
	private int comment_id;
	private int member_id;
	private Member member;
	private int story_id;
	private String content;
	private String date;
}
