package com.example.choudhary.EntityRepo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.choudhary.Entity.Patient;

public interface PatientRepo extends JpaRepository<Patient, Long> {

    @Query("SELECT DISTINCT p FROM Patient p JOIN p.bookAppointments a")
    List<Patient> findAllpatientWithAppoinment();
}
