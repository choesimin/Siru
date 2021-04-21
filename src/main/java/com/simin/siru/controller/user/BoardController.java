package com.simin.siru.controller.user;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.simin.siru.model.common.Pager;
import com.simin.siru.model.domain.Poem;
import com.simin.siru.model.domain.Story;
import com.simin.siru.model.service.PoemService;
import com.simin.siru.model.service.StoryService;

@Controller
public class BoardController {
	
	@Autowired
	private StoryService storyService;
	
	@Autowired
	private PoemService poemService;
	
	@RequestMapping(value = "/board/poem/list", method = RequestMethod.GET)
	public ModelAndView getPoemBoard(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		List<Poem> poem_list = poemService.getList();
		Pager pager = new Pager();

		pager.init(request, poem_list.size());
		
		mav.addObject("poem_list", poem_list);
		mav.addObject("pager", pager);
		mav.setViewName("board/poem/list");
		
		return mav;
	}
	@RequestMapping(value = "/board/story/list", method = RequestMethod.GET)
	public ModelAndView getStoryBoard(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		List<Story> story_list = storyService.getList();
		Pager pager = new Pager();

		pager.init(request, story_list.size());
		
		mav.addObject("story_list", story_list);
		mav.addObject("pager", pager);
		mav.setViewName("board/story/list");
		
		return mav;
	}

	
	@RequestMapping(value = "/board/poem/detail", method = RequestMethod.GET)
	public ModelAndView getPoemDetail(int poem_id) {
		ModelAndView mav = new ModelAndView();

		Poem poem = poemService.get(poem_id);

		mav.addObject("poem", poem);
		mav.setViewName("board/poem/detail");
		
		return mav;
	}
	@RequestMapping(value = "/board/story/detail", method = RequestMethod.GET)
	public ModelAndView getStoryDetail(int story_id) {
		ModelAndView mav = new ModelAndView();

		Story story = storyService.get(story_id);

		mav.addObject("story", story);
		mav.setViewName("board/story/detail");
		
		return mav;
	}
	
	
	
	
	@RequestMapping(value = "/board/regist/form", method = RequestMethod.GET)
	public String getRegistForm(HttpServletRequest request) {
		return "board/common/regist";
	}
	@RequestMapping(value = "/board/poem/regist", method = RequestMethod.POST)
	public String registPoem(HttpServletRequest request, Poem poem) {
		poemService.regist(poem);
		
		return "redirect:/user/board/poem/list";
	}
	@RequestMapping(value = "/board/story/regist", method = RequestMethod.POST)
	public String registStory(HttpServletRequest request, Story story) {
		storyService.regist(story);
		
		return "redirect:/user/board/story/list";
	}
	
	
	
	@RequestMapping(value = "/board/poem/modify/form", method = RequestMethod.POST)
	public ModelAndView getPoemModifyForm(HttpServletRequest request, Poem poem) {
		ModelAndView mav = new ModelAndView();
		
		Poem poem_result = poemService.get(poem.getPoem_id());
		
		mav.addObject("poem", poem_result);
		mav.setViewName("board/poem/modify");
		
		return mav;
	}
	@RequestMapping(value = "/board/story/modify/form", method = RequestMethod.POST)
	public ModelAndView getStoryModifyForm(HttpServletRequest request, Story story) {
		ModelAndView mav = new ModelAndView();
		
		Story story_result = storyService.get(story.getStory_id());
		
		mav.addObject("story", story_result);
		mav.setViewName("board/story/modify");
		
		return mav;
	}
	@RequestMapping(value = "/board/poem/modify", method = RequestMethod.POST)
	public String modifyPoem(HttpServletRequest request, Poem poem) {
		poemService.modify(poem);
		
		return "redirect:/user/board/poem/detail?poem_id=" + poem.getPoem_id();
	}
	@RequestMapping(value = "/board/story/modify", method = RequestMethod.POST)
	public String modifyStory(HttpServletRequest request, Story story) {
		storyService.modify(story);
		
		return "redirect:/user/board/story/detail?story_id=" + story.getStory_id();
	}
	

	
	@RequestMapping(value = "/board/poem/delete", method = RequestMethod.POST)
	public String deletePoem(HttpServletRequest request, Poem poem) {
		poemService.delete(poem.getPoem_id());
		
		return "redirect:/user/board/poem/list";
	}
	@RequestMapping(value = "/board/story/delete", method = RequestMethod.POST)
	public String deleteStory(HttpServletRequest request, Story story) {
		storyService.delete(story.getStory_id());
		
		return "redirect:/user/board/story/list";
	}
	
}
