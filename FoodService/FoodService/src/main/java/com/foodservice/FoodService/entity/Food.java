package com.foodservice.FoodService.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Food {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private double price;
	private boolean favorite;
	@Lob
	@Column(length = 50000000)
	private byte[] imageUrl;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "tag_id")
	private Tag tags;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="origin_id")
	private Origin origins;
	private String cookTime;
}
