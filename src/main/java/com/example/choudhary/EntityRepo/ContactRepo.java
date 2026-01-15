package com.example.choudhary.EntityRepo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.choudhary.Entity.Contact;

public interface ContactRepo extends JpaRepository<Contact, Integer> {

}
