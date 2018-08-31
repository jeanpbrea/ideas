package com.jean.ideas.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


import com.jean.ideas.models.User;
import com.jean.ideas.models.Idea;
import com.jean.ideas.services.IdeaService;
import com.jean.ideas.services.UserService;

@Controller
public class ShowController {
	private final UserService userService;
	private final IdeaService ideaService;
	
	public ShowController(IdeaService ideaService, UserService userService) {
		this.ideaService = ideaService;
		this.userService = userService;
	}
	
	@RequestMapping("/show/{id}")
	public String show(HttpSession session, @PathVariable("id") Long id, Model model) {
		Idea ideashow = ideaService.findIdea(id);
		Long userId = (Long) session.getAttribute("userId");
		User user = userService.findUserById(userId);
		model.addAttribute("user", user);
		model.addAttribute("idea", ideashow);
		return "show.jsp";
	}
}
