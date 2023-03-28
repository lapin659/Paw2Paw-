package com.webapp.paw2paw.repository;

import com.webapp.paw2paw.model.Reply;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReplyRepository extends JpaRepository<Reply, Long> {


//    @Transactional
  //  void deleteRepliesById(Long id);

   Long countRepliesByTopic_topicId(Long id);

   List<Reply> findReplyByUser_Id(Long id);
   List<Reply> findReplyByTopic_topicId(Long topic_id);

}
