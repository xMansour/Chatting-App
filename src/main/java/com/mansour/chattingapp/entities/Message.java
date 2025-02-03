package com.mansour.chattingapp.entities;

import com.mansour.chattingapp.audit.Updatable;
import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Table(name = "messages")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Message extends Updatable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", columnDefinition = "uuid", updatable = false, nullable = false)
    private UUID id;

    @Column(name = "sender_id", columnDefinition = "uuid", updatable = false, nullable = false)
    private UUID senderId;

    @Column(name = "receiver_id", columnDefinition = "uuid", updatable = false, nullable = false)
    private UUID receiverId;

    @Column(name = "content", nullable = false)
    private String content;

    @Column(name = "is_read", nullable = false)
    private boolean isRead = false;
}
