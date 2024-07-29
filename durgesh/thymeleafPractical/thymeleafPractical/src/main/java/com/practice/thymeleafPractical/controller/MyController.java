package com.practice.thymeleafPractical.controller;




import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;



@Controller
public class MyController {

	
	@RequestMapping(value="/about",method=RequestMethod.GET)
	public String about(Model model) {
		System.out.println("Inside About handler...");
		
		// putting data in model 
		model.addAttribute("name","Prasenjit Bhosale");
		model.addAttribute("currentDate",new Date().toLocaleString());
		
		// example 
//		String nameString = "abc";
//		nameString.toUpperCase();
		
		return "about";
		// about.html
	}
	
	
	
	// handling Iteration
	
	@GetMapping("/example-loop")
	public String iterateHandler(Model m) {
		
		// create a list, set collection
		
		 List<String> names = List.of("Prasejit","Peter","Thor","Wanda","Loki","Steve","Tony");
		
		 m.addAttribute("names",names);
		
		return "iterate";
	}
	
	
	
	// handler for including fragments 
	
	@GetMapping("/service")
	public String servicesHandler(Model model) {
		
		return "service";
	}
	
	
	
}
