package com.simin.siru.model.service;

import java.util.List;

import com.simin.siru.model.domain.Comment;

public interface CommentService {
	public void regist(Comment comment);
	public List<Comment> getCommentList(int story_id);
}
