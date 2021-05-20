package com.simin.siru.controller.index;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.simin.siru.model.domain.Banner;
import com.simin.siru.model.domain.Poem;
import com.simin.siru.model.domain.Story;
import com.simin.siru.model.service.BannerService;
import com.simin.siru.model.service.PoemService;
import com.simin.siru.model.service.StoryService;

@Controller
public class IndexController {
	
	@Autowired
	private PoemService poemService;

	@Autowired
	private StoryService storyService;
	
	@Autowired
	private BannerService bannerService;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView index() {
		ModelAndView mav = new ModelAndView();
		
		List<Poem> poem_list = poemService.getList();
		List<Story> story_list = storyService.getList();
		Poem[] poem_best_five = poemService.getBestFive();
		Story[] story_best_five = storyService.getBestFive();
		Banner banner = bannerService.getRecent();
		
		mav.setViewName("index");

		mav.addObject("poem_count", poem_list.size());
		mav.addObject("story_count", story_list.size());
		mav.addObject("poem_best_five", poem_best_five);
		mav.addObject("story_best_five", story_best_five);
		mav.addObject("banner", banner);
		
		return mav;
	}
	
}
