package com.example.choudhary.Entity;

import java.time.LocalDate;
import java.time.LocalTime;

import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class BookAppointment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String name;
	private String email;
	private String phone;

	private LocalDate date;
	private LocalTime time;

//	private String message;

	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "leadership_id", nullable = false)
	@ToString.Exclude
	private Leadership leadership;
	@ManyToOne
@JoinColumn(name = "patient_id")
private Patient patient;

}
