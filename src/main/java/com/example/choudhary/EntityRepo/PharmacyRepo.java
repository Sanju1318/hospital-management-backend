package com.example.choudhary.EntityRepo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.choudhary.Entity.Pharmacy;

@Repository
public interface PharmacyRepo extends JpaRepository<Pharmacy, Integer> {

}
