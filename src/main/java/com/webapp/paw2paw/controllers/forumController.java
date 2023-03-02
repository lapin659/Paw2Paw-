package com.webapp.paw2paw.controllers;


import com.webapp.paw2paw.model.ForumTopic;
import com.webapp.paw2paw.repository.TopicRepository;
import com.webapp.paw2paw.service.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class forumController {
    private final TopicRepository topicRepository;
    @Autowired
    public forumController(TopicRepository topicRepository) {
        this.topicRepository = topicRepository;
    }
    @Autowired
    private TopicService topicService;
    /**
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
 **/
    @GetMapping("/forum.html")
    public String listTopics(Model model){
        List<ForumTopic> listTopics = topicService.getAllTopics();
        model.addAttribute("listedtopics", listTopics);
        return "forum";
    }

    @GetMapping("topics/user/{id}")
    public String showTopicByUser(@PathVariable String id, Model model){
        //List<ForumTopic> forumTopics = topicRepository.findForumTopicsByUser_IdOrderByCreatedDate(Long.valueOf(id));
        //model.addAttribute("forumTopics", forumTopics);
        //ForumTopic selectedTopic = topicService.getTopicById(Long.valueOf(id));
        ForumTopic selectedTopic = topicService.getTopicByUser(id);
       // ForumTopic selected = topicRepository.findTopicById(Long.valueOf(id));
       // model.addAttribute("selected", selected);
        model.addAttribute("selectedTopic", selectedTopic);
        model.addAttribute("topicService", topicService);
        return "forum";

    }







}