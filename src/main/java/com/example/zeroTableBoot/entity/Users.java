package com.example.zeroTableBoot.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Users {
    @Id
    private String emailId;
    @Column(nullable = false)
    private String password;
    @Column(nullable = false)
    private String userName;
    @Column(columnDefinition = "varchar(255) default '/image/default'", nullable = false)
    private String profileImgUrl;
}
