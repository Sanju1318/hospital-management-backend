package com.example.choudhary.EntityDto;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class InsuranceDto {
	
	private int id;
	
	private String policyNumber;
	
//	@Column(nullable = false ,length = 100)
	private String provider;
	
//	@Column(nullable = false)
	private LocalDate validUnit;
	
	@CreationTimestamp
	@Column(nullable = false, updatable = false)
	private LocalDateTime createdAt;

}
