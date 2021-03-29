package com.simin.siru.controller.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.simin.siru.model.service.StoryService;

@RestController
public class BoardController {
	
	@Autowired
	private StoryService storyService;
	
	

}
