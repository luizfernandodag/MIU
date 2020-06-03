package edu.miu.cs.cs425.lesson11.mybooksmgmt.controller;

import edu.miu.cs.cs425.lesson11.mybooksmgmt.model.Publisher;
import edu.miu.cs.cs425.lesson11.mybooksmgmt.service.impl.PublisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
public class PublisherController {
    private PublisherService publisherService;

    @Autowired
    public PublisherController(PublisherService publisherService) {
        this.publisherService = publisherService;
    }

    @GetMapping(value = "/mybooksmgmtwebapp/publisher/list")
    public ModelAndView listPublisher() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("publishers", publisherService.getAllPublishers());
        modelAndView.setViewName("publisher/list");
        return modelAndView;

    }
    @GetMapping(value = "/mybooksmgmtwebapp/publisher/new")
    public String displayNewPublisherForm(Model model )
    {
        Publisher publisher = new Publisher();
        model.addAttribute("publisher", publisher);
        return  "publisher/new";
    }

    @PostMapping(value = "/mybooksmgmtwebapp/publisher/list")
    public String addNewPublisher(@Valid @ModelAttribute("publisher") Publisher publisher, BindingResult bindingResult, Model model)
    {
        if(bindingResult.hasErrors())
        {
            model.addAttribute("publisher", publisher);
            model.addAttribute("errors", bindingResult.getAllErrors());
        }
       // else
        //{
            publisherService.registerNewPublisher(publisher);
            return "redirect:/mybooksmgmtwebapp/publisher/list";
       // }

    }

}
