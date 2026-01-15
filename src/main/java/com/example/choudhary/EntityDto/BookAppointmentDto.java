package com.example.choudhary.EntityDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BookAppointmentDto {

    private int id;

    private String name;

    private String email;

    private String phone;

    // Frontend sends date as "YYYY-MM-DD"
    private String adddate;

    // Frontend sends time as "HH:mm"
    private String appointmentTime;

    // Frontend sends only doctor ID
    private int leadershipId;
}
