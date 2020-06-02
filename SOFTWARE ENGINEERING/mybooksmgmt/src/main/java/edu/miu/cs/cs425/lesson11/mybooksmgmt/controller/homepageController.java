package edu.miu.cs.cs425.lesson11.mybooksmgmt.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class homepageController {
    @GetMapping(value = {"/", "/index", "/home", "/mybooksmgmtwebapp/home"})
    public String showHomepage() {
        return "home/index";
    }
}
