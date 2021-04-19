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
	private CommentService commentService;
	
	@RequestMapping(value = "/comment/get", method = RequestMethod.GET, produces = "application/text;charset=utf8")
	public String get(int comment_id) {
		ObjectMapper mapper = new ObjectMapper();
		
		String jsonString = "";
		
		try {
			jsonString = mapper.writeValueAsString(commentService.get(comment_id));
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		
		return jsonString;
	}

	@RequestMapping(value = "/comment/list", method = RequestMethod.GET, produces = "application/text;charset=utf8")
	public String getList(int story_id) {
		ObjectMapper mapper = new ObjectMapper();
		
		String jsonString = "";
		
		try {
			jsonString = mapper.writeValueAsString(commentService.getList(story_id));
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		
		return jsonString;
	}
	
	@RequestMapping(value = "/comment/regist", method = RequestMethod.POST)
	public void regist(Comment comment) {
		commentService.regist(comment);
	}

	@RequestMapping(value = "/comment/modify", method = RequestMethod.POST)
	public void modify(Comment comment) {
		commentService.modify(comment);
	}
	
	@RequestMapping(value = "/comment/delete", method = RequestMethod.GET)
	public void delete(int comment_id) {
		commentService.delete(comment_id);
	}
	
}
