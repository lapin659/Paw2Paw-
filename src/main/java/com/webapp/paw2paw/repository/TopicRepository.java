package com.webapp.paw2paw.repository;

import com.webapp.paw2paw.model.ForumTopic;
import io.micrometer.core.lang.Nullable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TopicRepository extends JpaRepository<ForumTopic, Long> {
    @Query("SELECT t FROM ForumTopic t WHERE t.topicId = ?1")
    @Nullable
    ForumTopic findTopicById(Long id);

    List<ForumTopic> findForumTopicsByUser_Id(Long id);


}
