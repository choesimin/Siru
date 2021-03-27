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
	
	@RequestMapping(value = "/board/story", method = RequestMethod.GET)
	public ModelAndView story(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		List<Story> story_list = storyService.selectAll();
		Pager pager = new Pager();

		pager.init(request, story_list.size());
		
		mav.addObject("story_list", story_list);
		mav.addObject("pager", pager);
		mav.setViewName("board/story");
		
		return mav;
	}

	@RequestMapping(value = "/board/form/regist", method = RequestMethod.GET)
	public String registForm() {
		return "board/form/regist";
	}
	
	@RequestMapping(value = "/board/story/regist", method = RequestMethod.POST)
	public String registStory(Story story) {
		storyService.regist(story);
		
		return "redirect:/user/board/story";
	}
	
	@RequestMapping(value = "/board/detail/story", method = RequestMethod.GET)
	public ModelAndView storyDetail(int story_id) {
		ModelAndView mav = new ModelAndView();

		Story story = storyService.select(story_id);

		mav.addObject("story", story);
		mav.setViewName("board/detail/story");
		
		return mav;
	}

}
