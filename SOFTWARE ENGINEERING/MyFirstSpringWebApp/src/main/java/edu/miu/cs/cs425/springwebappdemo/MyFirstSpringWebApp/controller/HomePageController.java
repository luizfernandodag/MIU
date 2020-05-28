package edu.miu.cs.cs425.springwebappdemo.MyFirstSpringWebApp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomePageController {
	
	@GetMapping(value = {"/","/index","/home"})
	public String displayHomepage()
	{
		return "index";
	}
	

}
