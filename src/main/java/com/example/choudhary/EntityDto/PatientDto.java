package com.example.choudhary.EntityDto;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PatientDto {

    private int id;
    private String name;
    private String age;
    private String gender;
    private String address;
    private String mobileNumber;
    private String fee;
    private int insurence;

    private Set<PatientReviewDto> review = new HashSet<>();
    private List<BookAppointmentDto> appointmentDtos = new ArrayList<>();
}
