package com.simin.siru.controller.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.simin.siru.model.domain.Like;
import com.simin.siru.model.service.StoryService;

@RestController
public class BoardController {
	
	@Autowired
	StoryService storyService;
	
	@RequestMapping(value = "/story/like", method = RequestMethod.POST)
	public void likeStory(Like like) {
		storyService.like(like);
	}

	@RequestMapping(value = "/story/like/cancel", method = RequestMethod.POST)
	public void cancelLikeStory(Like like) {
		storyService.cancelLike(like);
	}

	@RequestMapping(value = "/story/like/count", method = RequestMethod.GET)
	public int countStoryLike(int story_id) {
		return storyService.countLike(story_id);
	}
	
	@RequestMapping(value = "/story/like/check", method = RequestMethod.POST)
	public boolean checkMemberStoryLike(Like like) {
		return storyService.checkMemberLike(like);
	}
}
