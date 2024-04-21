package com.example.zeroTableBoot.entity;

import com.example.zeroTableBoot.LocalDateTimeAttributeConverter;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class RecipeComments {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long recipeCommentId;
    @ManyToOne
    @JoinColumn(name = "recipeName", nullable = false)
    private Recipes recipes;
    @ManyToOne
    @JoinColumn(name = "emailId", nullable = false)
    private Users users;
    @Lob
    @Column(nullable = false)
    private String body;
    @Column(nullable = false)
    private LocalDateTime time;
}
