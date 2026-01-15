package com.example.choudhary.Entity;

import com.example.choudhary.EntityDto.OurStaffDto;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Data
@Table(name = "staff")

@Getter
@Setter

public class OurStaff {
	 @Id
	 @GeneratedValue(strategy = GenerationType.AUTO)
	
	private int staffId;
	
	private String imagename;
	
	private String sname;
	
	private String qualification;

}
