package com.example.choudhary.Entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
public class Report {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(nullable = false)
	private String reportName;
	
	@Column(nullable = false)
	private LocalDate reportDate;
	
	@Column(nullable = false)
	private String pdfPath;
	
	@ManyToOne
	@ToString.Exclude
//	@JoinColumn(nullable = false)
	private Patient patient;
	
	@ManyToOne
	@ToString.Exclude
//	@JoinColumn(nullable = false)
	private Leadership leadership;
	
	

	

}
