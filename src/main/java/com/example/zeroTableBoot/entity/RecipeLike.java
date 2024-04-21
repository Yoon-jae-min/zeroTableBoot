package com.example.zeroTableBoot.entity;

import jakarta.persistence.*;

@Entity
public class RecipeLike {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long recipeLikeId;

    @ManyToOne
    @JoinColumn(name = "emailId", nullable = false)
    private Users users;
    @ManyToOne
    @JoinColumn(name = "recipeName", nullable = false)
    private Recipes recipes;
}
