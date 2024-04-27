package com.example.zeroTableBoot.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class Ingredients {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ingredientId;
    @Column(nullable = false)
    private String ingredientName;
    @ManyToOne
    @JoinColumn(name = "emailId", nullable = false)
    private Users users;
    @Column(nullable = false)
    private Long quantity;
    @Column(nullable = false)
    private String unit;
    @Column(nullable = false)
    private String category;
    @Column(nullable = false)
    private LocalDateTime expirationDate;
}
