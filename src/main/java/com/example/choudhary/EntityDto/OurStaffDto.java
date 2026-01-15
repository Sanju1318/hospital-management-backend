package com.example.choudhary.EntityDto;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Data
@Getter
@Setter
@NoArgsConstructor
public class OurStaffDto {
	
	
	private int staffId;
	
	private String imagename;
	
	private String sname;
	
	private String qualification;

}

