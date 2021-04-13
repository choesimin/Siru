package com.simin.siru.model.domain;

import lombok.Data;

@Data
public class Like {
	
	private int like_id;
	private int member_id;
	private int poem_id;
	private int story_id;
	private int date;
	
	private int count;

}
