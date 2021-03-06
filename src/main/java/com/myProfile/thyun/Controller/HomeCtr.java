package com.myProfile.thyun.Controller;

import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.myProfile.thyun.Service.HomeSvc;
import com.myProfile.thyun.model.BlogHashtag;
import com.myProfile.thyun.model.BlogPost;

@Controller
public class HomeCtr {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeCtr.class);
	
	@Autowired
	private HomeSvc homeSvc;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String findPostList(Locale locale, Model model) {
		List<BlogPost> postList = homeSvc.findPostList();
//		logger.info("Welcome home! The client locale is {}.", locale);
		//System.out.println((String[])postList.get(0))[4]);// (String[])paramMap.get( key ) )[0]
		
		System.out.println(postList.get(0));
		model.addAttribute("postList",postList);		
		return "index";
	}	
	@RequestMapping(value = "/tag", method = RequestMethod.GET)
	public String findHashtagList(Locale locale, Model model) {		
		List<BlogHashtag> tagList = homeSvc.findHashtagList();
		System.out.println(tagList.size());
		model.addAttribute("tagList",tagList);
		return "tag";
	}
	
	@RequestMapping(value = "/about", method = RequestMethod.GET)
	public String findAboutPage(Locale locale, Model model) {
		return "about";
	}
	
	@RequestMapping("/favicon.ico")
    public String favicon() {
        return "forward:/images/favicon/favicon.ico";
    }


	
	

	
}
