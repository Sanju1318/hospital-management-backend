package com.example.choudhary.EntityRepo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.choudhary.Entity.Patient;

public interface PatientRepo extends JpaRepository<Patient, Integer>{
	
//	@Query("SELECT p FROM Patient p LEFT JOIN FETCH p.appointments a LEFT JOIN FETCH a.leadership")
//	@Query("SELECT p FROM Patient p LEFT JOIN FETCH p.appointments")
//	List<Patient> findAllpatientWithAppoinment();

}
