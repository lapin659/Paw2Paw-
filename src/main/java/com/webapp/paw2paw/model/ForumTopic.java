package com.webapp.paw2paw.model;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "topic")
public class ForumTopic {
    @Id
    @GeneratedValue
    private Long topicId;

    @Column(unique = true, length = 32)
    private String title;

    @Column(nullable = false, length = 1024)
    private String content;

    private LocalDateTime timeStamp;

    @ManyToOne
    @JoinColumn(name = "id_user")
    private User user;

    @OneToMany(mappedBy = "topic")
    private List<Reply> replies;

    public ForumTopic() {

    }

    public ForumTopic(Long topicId, String title, String content, LocalDateTime timeStamp, User user, List<Reply> replies) {
        super();
        this.topicId = topicId;
        this.title = title;
        this.content = content;
        this.timeStamp = timeStamp;
        this.user = user;
        this.replies = replies;
    }


    public ForumTopic(Long topicId, String title, User user) {
        this.topicId = topicId;
        this.title = title;
        this.user = user;
    }

//temp
    public ForumTopic(Long topicId, String title) {
        this.topicId = topicId;
        this.title = title;
    }
//////
    public Long getId() {
        return topicId;
    }

    public void setId(Long topicId) {
        this.topicId = topicId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDateTime getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(LocalDateTime timeStamp) {
        this.timeStamp = timeStamp;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Reply> getReplies() {
        return replies;
    }

    public void setAnswers(List<Reply> replies) {
        this.replies = replies;
    }

    public String showTimestamp() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm - dd.MM.yyyy");
        return this.timeStamp.format(formatter);
    }

}
