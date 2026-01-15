package com.example.choudhary.EntityRepo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.choudhary.Entity.Report;


public interface ReportRepo extends JpaRepository<Report, Integer> {

}
