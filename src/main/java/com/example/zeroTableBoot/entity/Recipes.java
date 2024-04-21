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
    @Column(columnDefinition = "varchar(255) default '기타' CHECK (status IN ('기타', '한식', '중식', '일식'))", nullable = false)
    private String category;
    @Column(columnDefinition = "varchar(255) default '/image/default'", nullable = false)
    private String recipeImgUrl;
    @Column(columnDefinition = "integer default 0", nullable = false)
    private Long watchCount;
    @Column(columnDefinition = "varchar(255) CHECK (status IN ('일반', '공유'))", nullable = false)
    private String recipeType;
}
