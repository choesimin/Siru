package com.simin.siru.controller.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.simin.siru.model.domain.Comment;
import com.simin.siru.model.service.CommentService;

@RestController
public class CommentController {
	
	@Autowired
	CommentService commentService;

	@RequestMapping(value = "/comment/list", method = RequestMethod.GET, produces = "application/text;charset=utf8")
	public String getList(int story_id) {
		ObjectMapper mapper = new ObjectMapper();
		
		String jsonString = "";
		
		try {
			jsonString = mapper.writeValueAsString(commentService.getCommentList(story_id));
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		
		return jsonString;
	}
	
	@RequestMapping(value = "/comment/regist", method = RequestMethod.POST)
	public void regist(Comment comment) {
		commentService.regist(comment);
	}
	
}
