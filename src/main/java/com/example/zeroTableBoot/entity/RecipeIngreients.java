package com.example.zeroTableBoot.entity;

import jakarta.persistence.*;

@Entity
public class RecipeIngreients {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long recipeIngredientId;
    @Column(nullable = false)
    private String ingredientName;

    @ManyToOne
    @JoinColumn(name = "recipeName", nullable = false)
    private Recipes recipes;
    @Column(nullable = false)
    private Long quantity;
    @Column(nullable = false)
    private String unit;
}
