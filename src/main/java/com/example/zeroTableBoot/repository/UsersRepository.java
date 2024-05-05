package com.example.zeroTableBoot.repository;

import com.example.zeroTableBoot.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository extends JpaRepository<Users, String> {

    boolean existsById(String emailId);
}
