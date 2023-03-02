package com.webapp.paw2paw.controllers;

import com.webapp.paw2paw.model.ForumTopic;
import com.webapp.paw2paw.model.User;
import com.webapp.paw2paw.repository.TopicRepository;
import com.webapp.paw2paw.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;

@Controller
public class newTopicController {
    private final UserRepository userRepo;
    private final TopicRepository topicRepo;
    //private final TopicService topicService;


    @Autowired
    public newTopicController(UserRepository userRepo, TopicRepository topicRepo) {
        this.userRepo = userRepo;
        this.topicRepo = topicRepo;
    }

    @GetMapping("newTopic/{id}")
    public String showNewTopic(@PathVariable String id, Model model, Principal principal){
        if(!principal.getName().isEmpty()) {
            String userName = principal.getName();
            //  Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            //   String userName = ((UserDetails)principal).getUsername();

            ForumTopic topic = topicRepo.findTopicById(Long.valueOf(id));

            topicRepo.save(topic);

            model.addAttribute("topic", topic);
            model.addAttribute("userName", userName);
        }else{
            model.addAttribute("newUser", new User());
        }
        return "newTopic";

    }

    @PostMapping("newTopic/{id}")
    public String updateTopic(@RequestParam String topic_Id){
        return "newTopic/" + topic_Id;
    }



}
