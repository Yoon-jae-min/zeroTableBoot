package com.example.zeroTableBoot.entity;

import com.example.zeroTableBoot.dto.UsersForm;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Users {
    @Id
    private String emailId;
    @Column(nullable = false)
    private String password;
    @Column(nullable = false)
    private String userName;
    @Column(nullable = false)
    private String profileImgUrl;
}
