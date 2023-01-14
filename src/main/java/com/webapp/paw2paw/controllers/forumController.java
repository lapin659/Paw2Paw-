package com.webapp.paw2paw.controllers;


import com.webapp.paw2paw.model.ForumTopic;
import com.webapp.paw2paw.repository.TopicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class forumController {
    private final TopicRepository topicRepository;
    @Autowired
    public forumController(TopicRepository topicRepository) {
        this.topicRepository = topicRepository;
    }
 @RequestMapping({"forum.html"})
    public String displayForum(Model model){
        return "forum";
    }

@GetMapping("forum")
public String displayTopics(Model m){
    List<ForumTopic> topics = topicRepository.findAll();
    m.addAttribute("topics", topics);
    return "forum";
}

}