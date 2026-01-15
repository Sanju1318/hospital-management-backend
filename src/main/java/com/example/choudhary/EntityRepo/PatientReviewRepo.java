package com.example.choudhary.EntityRepo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.choudhary.Entity.PatientReview;

public interface PatientReviewRepo extends JpaRepository<PatientReview, Integer> {

}
