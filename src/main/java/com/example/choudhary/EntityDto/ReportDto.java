package com.example.choudhary.EntityDto;

import java.time.LocalDate;

import com.example.choudhary.Entity.Leadership;
import com.example.choudhary.Entity.Patient;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ReportDto {

	private int id;
	private String reportName;
	
	@Column(nullable = false)
	private LocalDate reportDate;
	
	@Column(nullable = false)
	private String pdfPath;
	
    private int patient_Id;
    private int leadership_Id;


}
