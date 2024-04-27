package com.example.zeroTableBoot.service;

import com.example.zeroTableBoot.entity.Users;
import com.example.zeroTableBoot.repository.UsersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UsersRepository usersRepository;

    public void joinIn(Users users){
        usersRepository.save(users);
    }
}
