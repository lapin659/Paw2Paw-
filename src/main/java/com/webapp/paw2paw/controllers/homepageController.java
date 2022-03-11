package com.webapp.paw2paw.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class homepageController {
    @RequestMapping({"","/","homepage","homepage.html"})
    public String homepage(){
        return "homepage";
    }
}
