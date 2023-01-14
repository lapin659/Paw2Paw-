package com.webapp.paw2paw.service;

import com.webapp.paw2paw.model.ForumTopic;
import com.webapp.paw2paw.model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TopicService {

    public List<ForumTopic> getAllTopics() {
        List<ForumTopic> listOfTopics = new ArrayList<>();
        long User1 = 1000L;
        long User2 = 2000L;

        listOfTopics.add(new ForumTopic(User1, "UserA",  new User()));  //construct user or call usertitle?
        listOfTopics.add(new ForumTopic(User2, "UserB", new User()));

        return listOfTopics;
    }

}