package com.webapp.paw2paw.controllers;

import com.webapp.paw2paw.model.ForumTopic;
import com.webapp.paw2paw.model.Reply;
import com.webapp.paw2paw.model.User;
import com.webapp.paw2paw.repository.ReplyRepository;
import com.webapp.paw2paw.repository.TopicRepository;
import com.webapp.paw2paw.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;
import java.time.LocalDateTime;
import java.util.List;

@Controller
public class newTopicController {
    private final UserRepository userRepo;
    private final TopicRepository topicRepo;
    private final ReplyRepository replyRepo;


    @Autowired
    public newTopicController(UserRepository userRepo, TopicRepository topicRepo, ReplyRepository replyRepo) {
        this.userRepo = userRepo;
        this.topicRepo = topicRepo;
        this.replyRepo = replyRepo;
    }

    @GetMapping("newTopic/{id}")
    public String showNewTopic(@PathVariable String id, Model model, Principal principal){
        if(!principal.getName().isEmpty()) {
            String userEmail = principal.getName();
            String userName = userRepo.findByEmail(userEmail).getUsername();
            //  Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            //   String userName = ((UserDetails)principal).getUsername();
          //  Long userId = userRepo.findByUsername(userName).getId();
            ForumTopic topic = topicRepo.findTopicById(Long.valueOf(id));
          //  if (!replyRepo.findReplyByTopic_topicId(Long.valueOf(id)).isEmpty()) {
                List<Reply> replies = replyRepo.findReplyByTopic_topicId(Long.valueOf(id));
            //    topic.setAnswers(replies);
                model.addAttribute("replies", replies);

           // model.addAttribute("nullReply", new Reply());


            //topicRepo.save(topic);
            model.addAttribute("topic", topic);
            //model.addAttribute("userId", userId);
            model.addAttribute("userName", userName);

        }else{
            model.addAttribute("newUser", new User());
        }
        return "newTopic";

    }

    /**
    @PostMapping("newTopic/{id}")
    public RedirectView updateTopic(@RequestParam String topic_Id, HttpServletRequest request) {
        String contextPath = request.getContextPath();
        return new RedirectView(contextPath + "/newTopic/" + topic_Id);
    }
**/
    @PostMapping("newTopic")
    public RedirectView addAnswer(@RequestParam("content") String content,
                                  @RequestParam("id_topic") String id_topic,
                                  @RequestParam("userName") String userName,
                                  HttpServletRequest request) {
       // Long userId = userRepo.findByUsername(userName).getId();
        Reply reply= new Reply();
        reply.setContent(content);

        reply.setTimeStamp(LocalDateTime.now());
        reply.setTopic(topicRepo.findTopicById(Long.valueOf(id_topic)));
        reply.setUser(userRepo.findByUsername(userName));

        replyRepo.save(reply);
        String contextPath = request.getContextPath();
        return new RedirectView(contextPath + "/newTopic/" + id_topic);
    }







}
