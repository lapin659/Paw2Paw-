package com.webapp.paw2paw.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class forumController {
    public forumController() {
    }
 @RequestMapping({"forum.html"})
    public String displayForum(Model model){
        return "forum";
    }
}
