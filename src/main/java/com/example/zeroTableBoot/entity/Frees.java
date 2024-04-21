package com.example.zeroTableBoot.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class Frees {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long freeBoardId;
    @ManyToOne
    @JoinColumn(name = "emailId", nullable = false)
    private Users users;
    @Column(nullable = false)
    private String title;
    @Lob
    @Column(nullable = false)
    private String body;
    @Column(columnDefinition = "integer default 0", nullable = false)
    private Long watchCount;
    @Column(nullable = false)
    private LocalDateTime time;
}
