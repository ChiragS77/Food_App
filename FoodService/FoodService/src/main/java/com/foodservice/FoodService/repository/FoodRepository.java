package com.foodservice.FoodService.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.foodservice.FoodService.entity.Food;

@Repository
public interface FoodRepository extends JpaRepository<Food, Long> {

}
