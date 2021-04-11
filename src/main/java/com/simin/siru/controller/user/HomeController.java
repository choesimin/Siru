package com.simin.siru.controller.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.simin.siru.model.domain.Poem;
import com.simin.siru.model.domain.Story;
import com.simin.siru.model.service.PoemService;
import com.simin.siru.model.service.StoryService;

@Controller
public class HomeController {
	
	@Autowired
	private PoemService poemService;

	@Autowired
	private StoryService storyService;
	
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public ModelAndView home() {
		ModelAndView mav = new ModelAndView();
		
		List<Poem> poem_list = poemService.selectAll();
		List<Story> story_list = storyService.selectAll();
		
		mav.setViewName("home");
		mav.addObject("poem_list", poem_list);
		mav.addObject("story_list", story_list);
		
		return mav;
	}
	
}
