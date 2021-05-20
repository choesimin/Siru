package com.simin.siru.model.domain;

import lombok.Data;

@Data
public class Member {
	private int member_id;
	private String id;
	private String password;
	private String nickname;
	private String email;
	private String date;
}
