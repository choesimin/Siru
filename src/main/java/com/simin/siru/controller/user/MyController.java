package com.simin.siru.controller.user;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.simin.siru.model.common.Pager;
import com.simin.siru.model.domain.Member;
import com.simin.siru.model.domain.Poem;
import com.simin.siru.model.domain.Story;
import com.simin.siru.model.service.PoemService;
import com.simin.siru.model.service.StoryService;

@Controller
public class MyController {
	
	@Autowired
	private PoemService poemService;
	
	@Autowired
	private StoryService storyService;
	
	@RequestMapping(value = "/my/poem/list", method = RequestMethod.GET)
	public ModelAndView getPoemList(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		HttpSession session = request.getSession();

		Member member = (Member)session.getAttribute("member");
		
		List<Poem> poem_list = poemService.selectByMember(member.getMember_id());

		Pager pager = new Pager();
		pager.init(request, poem_list.size());
		
		mav.setViewName("my/poem/list");
		mav.addObject("poem_list", poem_list);
		mav.addObject("pager", pager);
		
		return mav;
	}
	
	@RequestMapping(value = "/my/story/list", method = RequestMethod.GET)
	public ModelAndView getStoryList(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		HttpSession session = request.getSession();

		Member member = (Member)session.getAttribute("member");

		List<Story> story_list = storyService.selectByMember(member.getMember_id());
		
		Pager pager = new Pager();
		pager.init(request, story_list.size());
		
		mav.setViewName("my/story/list");
		mav.addObject("story_list", story_list);
		mav.addObject("pager", pager);
		
		return mav;
	}
	
	@RequestMapping(value = "/my/info", method = RequestMethod.GET)
	public String getInfo() {
		return "";
	}
	

}
