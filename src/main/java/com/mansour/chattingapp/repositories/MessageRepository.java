package com.mansour.chattingapp.repositories;

import com.mansour.chattingapp.entities.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

public interface MessageRepository extends JpaRepository<Message, UUID> {

    @Transactional
    @Modifying
    @Query("UPDATE Message m SET m.isRead = :read WHERE m.id = :messageId")
    void updateReadReceipt(UUID messageId, boolean read);
}
