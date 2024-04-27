package com.example.zeroTableBoot.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Recipes {

    @Id
    private String recipeName;
    @Column(nullable = false)
    private String howTo;
    @Column
    private Long time;
    @Column(nullable = false)
    private String category;
    @Column(nullable = false)
    private String recipeImgUrl;
    @Column(nullable = false)
    private Long watchCount;
    @Column(nullable = false)
    private String recipeType;
}
