package edu.miu.cs.cs425.lesson11.mybooksmgmt.controller;

import edu.miu.cs.cs425.lesson11.mybooksmgmt.service.PublisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PublisherController {

    private PublisherService publisherService;

    @Autowired
    public PublisherController(PublisherService publisherService) {
        this.publisherService = publisherService;
    }

    @GetMapping(value = "/mybooksmgmtwebapp/publisher/list")
    public ModelAndView listPublishers() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("publishers", publisherService.getAllPublishers());
        modelAndView.setViewName("publisher/list");
        return modelAndView;
    }


}
