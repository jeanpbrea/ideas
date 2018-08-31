package com.jean.ideas.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import com.jean.ideas.models.Idea;
import com.jean.ideas.models.User;

import com.jean.ideas.services.IdeaService;
import com.jean.ideas.services.UserService;

@Controller
public class IdeaController {
	private final UserService userService;
	private final IdeaService ideaService;
	
	public IdeaController(IdeaService ideaService, UserService userService) {
		this.ideaService = ideaService;
		this.userService = userService;
	}
	
	@RequestMapping("/ideas")
    public String index(HttpSession session, Model model, @ModelAttribute("newidea") Idea idea) {
		Long userId = (Long) session.getAttribute("userId");
		User user = userService.findUserById(userId);
		List<Idea> ideas = ideaService.allIdea();
        model.addAttribute("ideas", ideas);
        model.addAttribute("user", user);
		return "dashboard.jsp";
	}
	@RequestMapping("/logout")
	 public String logout(HttpSession session) {
	     session.invalidate();
	     return "redirect:/";
	}
	@RequestMapping("/ideas/new")
	public String cidea( HttpSession session, Model model, @ModelAttribute("newidea") Idea idea)  {
		Long userId = (Long) session.getAttribute("userId");
		User user = userService.findUserById(userId);
		model.addAttribute("user", user);
		return "/newidea.jsp";
	}
	
	
	@RequestMapping(value="/createidea", method=RequestMethod.POST)
	public String createi(@Valid @ModelAttribute("newidea") Idea idea, BindingResult result) {
		if(result.hasErrors()) {
			return "newidea.jsp"; 
		} else {
			ideaService.createIdea(idea);
			return "redirect:/ideas";
		}
	}
	
//	@RequestMapping("/join/{id}")
//	 public String join(HttpSession session, @PathVariable("id") Long id) {
//		 Long userId = (Long) session.getAttribute("userId");
//		 User user = userService.findUserById(userId);
//		 Idea idea = ideaService.findIdea(id);
//		 idea.getUsers().add(user);
//		 ideaService.updateIdea(idea);
//		 return "redirect:/ideas";
//	}
	 @RequestMapping("/edit/{id}")
	 public String edit(@PathVariable("id") Long id, Model model, @ModelAttribute("editidea") Idea idea, HttpSession session) {
		 Long userId = (Long) session.getAttribute("userId");
		 User user = userService.findUserById(userId);
		 Idea ideaedit = ideaService.findIdea(id);
		 model.addAttribute("idea", ideaedit);
		 model.addAttribute("user", user);
		 return "edit.jsp";
	 }
	 @RequestMapping(value="/edit/{id}", method=RequestMethod.PUT)
	 public String update(@Valid @ModelAttribute("editidea") Idea idea, BindingResult result, @PathVariable("id") Long id, Model model) {
		 if (result.hasErrors()) {
			 Idea ideaedit = ideaService.findIdea(id);
			 model.addAttribute("idea", ideaedit);
			 return "edit.jsp";
		 } else {
			 ideaService.updateIdea(idea);
			 return "redirect:/ideas";
		 }
	 }
	 
//	 @RequestMapping("/cancel/{id}")
//	 public String cancel(HttpSession session, @PathVariable("id") Long id) {
//	     Long userId = (Long) session.getAttribute("userId");
//	     User user = userService.findUserById(userId);
//	     Idea idea = ideaService.findIdea(id);
//	     idea.getUsers().remove(user);
//		 ideaService.updateIdea(idea);
//	     return "redirect:/ideas";
//	 }
	 @RequestMapping(value="/delete/{id}")
	 public String destory(@PathVariable("id") Long id) {
		 ideaService.deleteIdea(id);
		 return "redirect:/ideas";
	 }

}
