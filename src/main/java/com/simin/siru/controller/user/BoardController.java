package com.simin.siru.controller.user;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.simin.siru.model.common.Pager;
import com.simin.siru.model.domain.Story;
import com.simin.siru.model.service.StoryService;

@Controller
public class BoardController {
	
	@Autowired
	StoryService storyService;
	
	@RequestMapping(value = "/board/story/list", method = RequestMethod.GET)
	public ModelAndView getStoryBoard(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		List<Story> story_list = storyService.selectAll();
		Pager pager = new Pager();

		pager.init(request, story_list.size());
		
		mav.addObject("story_list", story_list);
		mav.addObject("pager", pager);
		mav.setViewName("board/story/list");
		
		return mav;
	}

	@RequestMapping(value = "/board/story/detail", method = RequestMethod.GET)
	public ModelAndView getStoryDetail(int story_id) {
		ModelAndView mav = new ModelAndView();

		Story story = storyService.select(story_id);

		mav.addObject("story", story);
		mav.setViewName("board/story/detail");
		
		return mav;
	}

	@RequestMapping(value = "/board/common/regist", method = RequestMethod.GET)
	public String getRegistForm() {
		return "board/common/regist";
	}
	
	@RequestMapping(value = "/board/story/regist", method = RequestMethod.POST)
	public String registStory(Story story) {
		storyService.regist(story);
		
		return "redirect:/user/board/story/list";
	}
	
	
	@RequestMapping(value = "/board/story/modify/form", method = RequestMethod.GET)
	public ModelAndView getStoryModifyForm(int story_id) {
		ModelAndView mav = new ModelAndView();
		
		Story story = storyService.select(story_id);
		
		mav.addObject("story", story);
		mav.setViewName("board/story/modify");
		
		return mav;
	}
	
	@RequestMapping(value = "/board/story/modify", method = RequestMethod.POST)
	public String modifyStory(Story story) {
		storyService.modify(story);
		
		return "redirect:/user/board/story/detail?story_id=" + story.getStory_id();
	}
	
	@RequestMapping(value = "/board/story/delete", method = RequestMethod.GET)
	public String deleteStory(int story_id) {
		storyService.delete(story_id);
		
		return "redirect:/user/board/story/list";
	}

}
