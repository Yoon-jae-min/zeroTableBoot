package com.example.zeroTableBoot.repository;

import com.example.zeroTableBoot.entity.Notices;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NoticesRepository extends JpaRepository<Notices, String> {
}
