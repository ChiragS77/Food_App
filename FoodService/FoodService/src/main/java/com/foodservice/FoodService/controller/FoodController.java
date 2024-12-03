package com.foodservice.FoodService.controller;

import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import com.foodservice.FoodService.entity.Food;
import com.foodservice.FoodService.entity.Tag;
import com.foodservice.FoodService.repository.FoodRepository;
import com.foodservice.FoodService.repository.TagRepository;
import com.foodservice.FoodService.service.FoodService;

@RestController
@RequestMapping("/api/food")
@CrossOrigin(value = "http://localhost:4200")
public class FoodController {


	@Autowired
	private FoodService foodService;
	
	@Autowired
	private FoodRepository foodRepository;
	
	@Autowired
	private TagRepository tagRepository;
	



	@PostMapping
	public ResponseEntity<Food> addFood(@RequestBody Food food) throws IOException {

		Food f = null;

		try {
			f = this.foodService.addFood(food);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(f);

	}

	
	
	@PostMapping("/{id}/addImg")
	public ResponseEntity<Food> addfoodImage(@PathVariable Long id, @RequestPart MultipartFile file)
			throws IOException {

		Food f = null;

		try {
			f = this.foodService.addFoodImage(id, file);

		} catch (Exception e) {

			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}

		return ResponseEntity.ok(f);
	}
	
	@GetMapping("/all")
	public List<Food>  getTotal(){
		List<Food> list = this.foodRepository.findAll();
		
		return list;
	}
	
	
	
	@GetMapping("/tags")
	public Set<String> getTags() {
     
		List<Tag> tagList = this.tagRepository.findAll();
		
		Set<String> tags = tagList.stream().map(tag -> tag.getName().toLowerCase()).collect(Collectors.toSet());
		
		return tags;
	}
	
	

}
