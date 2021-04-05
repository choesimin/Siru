package com.simin.siru.model.service;

import java.util.List;

import com.simin.siru.model.domain.Comment;

public interface CommentService {
	public void regist(Comment comment);
	public Comment  get(int comment_id);
	public List<Comment> getList(int story_id);
	public void modify(Comment comment);
	public void delete(int comment_id);
}
