package com.example.springsecurity6withjwt.repository;

import com.example.springsecurity6withjwt.dto.ConversationDto;
import com.example.springsecurity6withjwt.entity.Conversation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ConversationRepository extends JpaRepository<Conversation, Long> {
    List<Conversation> findByUser1IdOrUser2Id(Long userId1, Long userId2);
    Conversation findByUser1IdAndUser2Id(Long user1Id, Long user2Id);
}
