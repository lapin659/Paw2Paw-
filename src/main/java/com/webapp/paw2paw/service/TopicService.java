package com.webapp.paw2paw.service;

import com.webapp.paw2paw.model.ForumTopic;
import com.webapp.paw2paw.model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@Service
public class TopicService {

    public List<ForumTopic> getAllTopics() {
        List<ForumTopic> listOfTopics = new ArrayList<>();
        long User1 = 1000L;
        long User2 = 2000L;
        User USER1 = new User();
        User USER2 = new User();

        listOfTopics.add(new ForumTopic(User1, "TitleA"));

        listOfTopics.add(new ForumTopic(User1, "TitleA", USER1));  //construct user or call usertitle?
        listOfTopics.add(new ForumTopic(User2, "TitleB", USER2));

        return listOfTopics;
    }



    public ForumTopic getTopicById(Long topicId) {

        Predicate<ForumTopic> byId = p -> p.getId().equals(topicId);
        return filterTopics(byId);
    }

    public ForumTopic filterTopics(Predicate<ForumTopic> strategy) {
        return getAllTopics().stream().filter(strategy).findFirst().orElse(null);
    }




}