package com.example.zeroTableBoot.repository;

import com.example.zeroTableBoot.entity.RecipeIngreients;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecipeIngredientsRepository extends JpaRepository<RecipeIngreients, Long> {
}
