package com.simin.siru.controller.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.simin.siru.model.domain.Story;
import com.simin.siru.model.service.StoryService;

@Controller
public class HomeController {
	
	@Autowired
	private StoryService storyService;
	
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public ModelAndView home() {
		ModelAndView mav = new ModelAndView();
		
		List<Story> story_list = storyService.selectAll();
		
		mav.setViewName("home");
		mav.addObject("story_list", story_list);
		
		return mav;
	}
	
}
