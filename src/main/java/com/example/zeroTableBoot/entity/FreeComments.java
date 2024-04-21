package com.example.zeroTableBoot.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class FreeComments {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long freeCommentId;
    @ManyToOne
    @JoinColumn(name = "freeBoardId", nullable = false)
    private Frees frees;
    @ManyToOne
    @JoinColumn(name = "emailId", nullable = false)
    private Users users;
    @Lob
    @Column(nullable = false)
    private String body;
    @Column(nullable = false)
    private LocalDateTime time;
}
