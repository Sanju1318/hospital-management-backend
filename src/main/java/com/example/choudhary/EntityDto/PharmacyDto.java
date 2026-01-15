package com.example.choudhary.EntityDto;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PharmacyDto {
	
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	private int id;
	
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
