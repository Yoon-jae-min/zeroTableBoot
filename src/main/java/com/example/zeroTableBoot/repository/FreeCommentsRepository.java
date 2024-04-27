package com.example.zeroTableBoot.repository;

import com.example.zeroTableBoot.entity.FreeComments;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FreeCommentsRepository extends JpaRepository<FreeComments, Long> {
}
