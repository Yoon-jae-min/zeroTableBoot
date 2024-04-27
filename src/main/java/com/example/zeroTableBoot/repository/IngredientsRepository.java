package com.example.zeroTableBoot.repository;

import com.example.zeroTableBoot.entity.Ingredients;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IngredientsRepository extends JpaRepository<Ingredients, Long> {
}
