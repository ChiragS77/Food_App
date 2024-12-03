package com.foodservice.FoodService.service;

import java.io.IOException;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.multipart.MultipartFile;

import com.foodservice.FoodService.entity.Food;
import com.foodservice.FoodService.repository.FoodRepository;

@Service
public class FoodService {

	@Autowired
	private FoodRepository foodRepository;

	
	   public Food addFood(Food food)
	{   
		Food f = this.foodRepository.save(food);
		
		if(Objects.isNull(f)) {
			return null;
		}
		
		return f;
	}
	   
	   
	   public Food addFoodImage(Long id ,MultipartFile file) throws IOException {
		  Food f =  this.foodRepository.findById(id).get();
		  
		  if(Objects.isNull(f)) {
			  return null;
		  }
		 
		  f.setImageUrl(file.getBytes());
		  this.foodRepository.save(f);
		  
		  return f;
	   }
	   
	  
}
