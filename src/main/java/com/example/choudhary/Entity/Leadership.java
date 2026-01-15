package com.example.choudhary.Entity;

import java.util.*;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Leadership {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int lid;

	private String lname;
	private String lphoto;
	private String lqualification;

	@ManyToMany(mappedBy = "leaderships")
	@ToString.Exclude
	private Set<Department> departments = new HashSet<>();

//	@ElementCollection
	@OneToMany(mappedBy = "leadership",
			   cascade = CascadeType.ALL,
			   orphanRemoval = true,
			   fetch = FetchType.LAZY)
	@ToString.Exclude
	private List<BookAppointment> appointments = new ArrayList<>();
}
