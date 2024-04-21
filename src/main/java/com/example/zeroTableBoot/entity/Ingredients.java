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
    @Column(columnDefinition = "varchar(255) default '개' CHECK (status IN ('개', '', ''))", nullable = false)
    private String unit;
    @Column(columnDefinition = "varchar(255) default '기타' CHECK (status IN ('기타', '한식', '중식', '일식'))", nullable = false)
    private String category;
    @Column(nullable = false)
    private LocalDateTime expirationDate;
}
