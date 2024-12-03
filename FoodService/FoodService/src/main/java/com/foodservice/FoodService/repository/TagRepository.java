package com.foodservice.FoodService.repository;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.foodservice.FoodService.entity.Tag;

@Repository
public interface TagRepository extends JpaRepository<Tag, Long> {

	
}
