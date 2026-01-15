package com.example.choudhary.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Data
@Getter 
@Setter
public class Pharmacy {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(nullable = false)
	@NotBlank(message = "Name is required")
	private String name;
	
	@Column(nullable = false)
	@NotBlank(message = "Category is required")
	private String category;
	
	@Column(nullable = false)
	@NotBlank(message = "Price is required")
	private String price;
	
	@Column(nullable = false)
	@NotBlank(message = "Stock is required")
	private String stock;
	

}
