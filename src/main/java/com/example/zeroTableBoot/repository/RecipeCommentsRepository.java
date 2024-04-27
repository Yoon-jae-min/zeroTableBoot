package com.example.zeroTableBoot.repository;

import com.example.zeroTableBoot.entity.RecipeComments;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecipeCommentsRepository extends JpaRepository<RecipeComments, Long> {
}
