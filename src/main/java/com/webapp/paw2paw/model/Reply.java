package com.webapp.paw2paw.model;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "reply")
public class Reply {
    @Id
    @GeneratedValue
    private Long ReplyId;

    @Column(nullable = false, length = 1024)
    private String content;

    private LocalDateTime timeStamp;

    @Column(length = 1024)
    private String code;

    @ManyToOne
    @JoinColumn(name = "id_user")
    private User user;

    @ManyToOne
    @JoinColumn(name = "id_topic")
    private ForumTopic topic;

    public Long getId() {
        return ReplyId;
    }

    public void setId(Long ReplyId) {
        this.ReplyId = ReplyId;
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

    public ForumTopic getTopic() {
        return topic;
    }

    public void setTopic(ForumTopic topic) {
        this.topic = topic;
    }

    public String showTimestamp() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm - dd.MM.yyyy");
        return this.timeStamp.format(formatter);
    }


}
