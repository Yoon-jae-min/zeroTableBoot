package com.example.zeroTableBoot.dto;

import com.example.zeroTableBoot.entity.Users;
import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class UsersForm {
    private String emailId;
    private String password;
    private String userName;
    private String profileImgUrl = "/image/default";



    public Users toEntity(String emailId, String password, String userName){
        return new Users(emailId, password, userName, this.profileImgUrl);
    }
}
