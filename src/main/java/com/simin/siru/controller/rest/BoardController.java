package com.simin.siru.controller.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.simin.siru.model.domain.Like;
import com.simin.siru.model.service.PoemService;
import com.simin.siru.model.service.StoryService;

@RestController
public class BoardController {
	
	@Autowired
	StoryService storyService;

	@Autowired
	PoemService poemService;
	

	@RequestMapping(value = "/poem/like", method = RequestMethod.POST)
	public void likePoem(Like like) {
		poemService.like(like);
	}
	@RequestMapping(value = "/story/like", method = RequestMethod.POST)
	public void likeStory(Like like) {
		storyService.like(like);
	}


	@RequestMapping(value = "/poem/like/cancel", method = RequestMethod.POST)
	public void cancelLikePoem(Like like) {
		poemService.cancelLike(like);
	}
	@RequestMapping(value = "/story/like/cancel", method = RequestMethod.POST)
	public void cancelLikeStory(Like like) {
		storyService.cancelLike(like);
	}


	@RequestMapping(value = "/poem/like/count", method = RequestMethod.GET)
	public int countPoemLike(int poem_id) {
		return poemService.countLike(poem_id);
	}
	@RequestMapping(value = "/story/like/count", method = RequestMethod.GET)
	public int countStoryLike(int story_id) {
		return storyService.countLike(story_id);
	}

	
	@RequestMapping(value = "/poem/like/check", method = RequestMethod.POST)
	public boolean checkMemberPoemLike(Like like) {
		return poemService.checkMemberLike(like);
	}
	@RequestMapping(value = "/story/like/check", method = RequestMethod.POST)
	public boolean checkMemberStoryLike(Like like) {
		return storyService.checkMemberLike(like);
	}
}
