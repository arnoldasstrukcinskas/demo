package com.example.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {
    @GetMapping(value="/index")
    public String getHome(){
        return "index";
    }

    @GetMapping(value="/resume")
    public String getResume(){
        return "resume";
    }

    @GetMapping(value="/projects")
    public String getProjects(){
        return "projects";
    }

    @GetMapping(value = "/contacts")
    public String getContacts(){
        return "contact";
    }
}
