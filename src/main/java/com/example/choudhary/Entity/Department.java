package com.example.choudhary.Entity;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Department {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(nullable = false, unique = true, length = 100)
	private String name;

	// ✅ Department → Head Leadership
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "head_leader_id")
	@ToString.Exclude
	private Leadership headLeader;

	// ✅ Department ↔ Leadership (Owning side)
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(
		name = "my_dpt_leaders",
		joinColumns = @JoinColumn(name = "dpt_id"),
		inverseJoinColumns = @JoinColumn(name = "leader_id")
	)
	@ToString.Exclude
	private Set<Leadership> leaderships = new HashSet<>();
}
