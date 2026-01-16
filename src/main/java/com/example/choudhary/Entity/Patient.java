package com.example.choudhary.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "patient")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "patient_name")
    private String name;

    private String age;
    private String gender;
    private String address;
    private String mobileNumber;

    @Column(name = "slip_fee")
    private String fee;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "patient_insurance_id")
    private Insurance insurance;

    // ❌ REMOVED — THIS WAS CRASHING THE APP
    // private List<BookAppointment> appointments;

    @OneToMany(mappedBy = "patient", cascade = CascadeType.REMOVE, fetch = FetchType.EAGER)
    private List<Report> report = new ArrayList<>();
        @OneToMany(mappedBy = "patient", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<BookAppointment> appointments;

}
