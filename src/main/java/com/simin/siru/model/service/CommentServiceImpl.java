package com.simin.siru.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.simin.siru.model.domain.Comment;
import com.simin.siru.model.repository.CommentDAO;

@Service
public class CommentServiceImpl implements CommentService {
	
	@Autowired
	private CommentDAO commentDAO;

	@Override
	public Comment get(int comment_id) {
		return commentDAO.select(comment_id);
	}

	@Override
	public void regist(Comment comment) {
		commentDAO.insert(comment);
	}

	@Override
	public List<Comment> getList(int story_id) {
		return commentDAO.selectByStoryId(story_id);
	}

	@Override
	public void modify(Comment comment) {
		commentDAO.update(comment);
	}

	@Override
	public void delete(int comment_id) {
		commentDAO.delete(comment_id);
	}

}
