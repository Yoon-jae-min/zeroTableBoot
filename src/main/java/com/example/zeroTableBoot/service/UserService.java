package com.example.zeroTableBoot.service;

import com.example.zeroTableBoot.entity.Users;
import com.example.zeroTableBoot.repository.UsersRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UsersRepository usersRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Transactional
    public String joinIn(Users users){
        try{
            users.setPassword(bCryptPasswordEncoder.encode(users.getPassword()));
            usersRepository.save(users);
        }
        catch (Exception e){
            return "failure";
        }
        return "success";
    }
}
