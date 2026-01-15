package com.example.choudhary.EntityRepo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.choudhary.Entity.BookAppointment;

public interface BookAppointmentRepo extends JpaRepository<BookAppointment, Integer> {

}
