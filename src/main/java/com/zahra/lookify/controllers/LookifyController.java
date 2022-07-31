package com.zahra.lookify.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.zahra.lookify.models.Lookify;
import com.zahra.lookify.services.LookifyService;

@Controller
public class LookifyController {

	@Autowired
	LookifyService lookifyService;
	
	@RequestMapping("/")
	public String home() {
		return"index.jsp";
	}
	
	@RequestMapping("/dashboard")
	public String dash(Model model) {
		List<Lookify> allLookifies = lookifyService.allLookifies();
		model.addAttribute("songs",allLookifies);
		return"dash.jsp";
	}
	
	@RequestMapping("/songs/new")
	public String addSong(@ModelAttribute("song") Lookify lookify) {
		return "add.jsp";
	}
	
	@RequestMapping(value="/songs/new", method=RequestMethod.POST)
	public String create(@Valid @ModelAttribute("song") Lookify lookify, BindingResult result) {
		if(result.hasErrors()) {
			return "add.jsp";
		} else {
			lookifyService.createLookify(lookify);
			return "redirect:/dashboard";
		}
	}
	
	@RequestMapping("/songs/{id}")
	public String show(@PathVariable("id") Long id, Model model) {
		Lookify lookify = lookifyService.findLookify(id);
		model.addAttribute("song", lookify);
		return "show.jsp";
	}
	
	@RequestMapping(value="/songs/{id}", method=RequestMethod.DELETE) 
	public String destroy(@PathVariable("id") Long id) {
		lookifyService.deleteLookify(id);
		return "redirect:/dashboard";
	}
	
	@RequestMapping("/search/{artist}")
	public String search(@PathVariable("artist") String artist, Model model) {
		List<Lookify> songs = lookifyService.artistAllSongs(artist);
		model.addAttribute("songs", songs);
		return "search.jsp";
	}
	
	@RequestMapping(value="/search", method=RequestMethod.POST)
	public String searchFor(@RequestParam("artist") String artist) {
		return "redirect:/search/"+artist;
	}
	
	@RequestMapping("/search/topten")
	public String topTen(Model model) {
		List<Lookify> topTen = lookifyService.findTopTen();
		model.addAttribute("topTen" , topTen);
		return "top.jsp";
	}
	
}
