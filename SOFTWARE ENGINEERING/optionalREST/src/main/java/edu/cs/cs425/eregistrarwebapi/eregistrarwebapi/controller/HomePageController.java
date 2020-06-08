package edu.cs.cs425.eregistrarwebapi.eregistrarwebapi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomePageController {
    @GetMapping(value = {"/","index","/home", "/eregistrar/home"})
    public String showHomepage()
    {
        return "home/index";
    }
}
