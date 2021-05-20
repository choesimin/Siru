package com.simin.siru.controller.admin;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.simin.siru.model.common.Pager;
import com.simin.siru.model.domain.Banner;
import com.simin.siru.model.domain.Member;
import com.simin.siru.model.domain.Poem;
import com.simin.siru.model.domain.Story;
import com.simin.siru.model.service.BannerService;
import com.simin.siru.model.service.MemberService;
import com.simin.siru.model.service.PoemService;
import com.simin.siru.model.service.StoryService;

@Controller
public class AdminController {
	
	@Autowired
	private MemberService memberService;

	@Autowired
	private PoemService poemService;
	
	@Autowired
	private StoryService storyService;
	
	@Autowired
	private BannerService bannerService;
	
	@RequestMapping(value = "/poem/list", method = RequestMethod.GET)
	public ModelAndView getPoemList(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		List<Poem> poem_list = poemService.getList();
		Pager pager = new Pager();

		pager.init(request, poem_list.size());
		
		mav.addObject("poem_list", poem_list);
		mav.addObject("pager", pager);
		mav.setViewName("admin/poem/list");
		
		return mav;
	}
	@RequestMapping(value = "/story/list", method = RequestMethod.GET)
	public ModelAndView getStoryList(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		List<Story> story_list = storyService.getList();
		Pager pager = new Pager();

		pager.init(request, story_list.size());
		
		mav.addObject("story_list", story_list);
		mav.addObject("pager", pager);
		mav.setViewName("admin/story/list");
		
		return mav;
	}
	@RequestMapping(value = "/member/list", method = RequestMethod.GET)
	public ModelAndView getInformation(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		List<Member> member_list = memberService.getList();
		Pager pager = new Pager();

		pager.init(request, member_list.size());
		
		mav.setViewName("admin/member/list");
		mav.addObject("member_list", member_list);
		mav.addObject("pager", pager);
		
		return mav;
	}
	
	@RequestMapping(value = "/poem/modify/form", method = RequestMethod.GET)
	public ModelAndView getPoemModifyForm(HttpServletRequest request, int poem_id) {
		ModelAndView mav = new ModelAndView();
		Poem poem = poemService.get(poem_id);
		
		mav.setViewName("admin/poem/modify");
		mav.addObject("poem", poem);
		
		return mav;
	}
	@RequestMapping(value = "/story/modify/form", method = RequestMethod.GET)
	public ModelAndView getStoryModifyForm(HttpServletRequest request, int story_id) {
		ModelAndView mav = new ModelAndView();
		Story story = storyService.get(story_id);
		
		mav.setViewName("admin/story/modify");
		mav.addObject("story", story);
		
		return mav;
	}
	@RequestMapping(value = "/member/information", method = RequestMethod.GET)
	public ModelAndView getMemberModifyForm(HttpServletRequest request, int member_id) {
		ModelAndView mav = new ModelAndView();
		Member member = memberService.get(member_id);
		
		mav.setViewName("admin/member/information");
		mav.addObject("member", member);
		
		return mav;
	}
	
	@RequestMapping(value = "/banner/regist/form", method = RequestMethod.GET)
	public ModelAndView getBannerRegistForm(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		Banner banner = bannerService.getRecent();
		
		mav.setViewName("admin/banner/regist");
		mav.addObject("banner", banner);
		
		return mav;
	}
	
	@RequestMapping(value = "/banner/regist", method = RequestMethod.POST)
	public String registBanner(HttpServletRequest request, Banner banner) {
		bannerService.regist(banner);
		
		return "redirect:/";
	}
	

}
