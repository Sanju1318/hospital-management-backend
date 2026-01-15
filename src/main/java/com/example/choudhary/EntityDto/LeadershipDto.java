package com.example.choudhary.EntityDto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class LeadershipDto {

    private Integer lid;        // ❌ NO @Id
    private String lname;
    private String lphoto;
    private String lqualification;
}
