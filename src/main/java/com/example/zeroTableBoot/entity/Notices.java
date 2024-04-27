package com.example.zeroTableBoot.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;

@Entity
public class Notices {
    @Id
    private String title;
    @Lob
    @Column(nullable = false)
    private String body;
    @Column(nullable = false)
    private String noticeImgUrl;
    @Column(nullable = false)
    private Long watchCount;
}
