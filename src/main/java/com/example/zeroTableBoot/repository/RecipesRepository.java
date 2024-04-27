package com.example.zeroTableBoot.repository;

import com.example.zeroTableBoot.entity.Recipes;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecipesRepository extends JpaRepository<Recipes, String> {
}
