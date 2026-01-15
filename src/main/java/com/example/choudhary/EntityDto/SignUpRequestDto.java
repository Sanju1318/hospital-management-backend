package com.example.choudhary.EntityDto;

import java.util.HashSet;
import java.util.Set;

//import com.example.choudhary.Type.RoleType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SignUpRequestDto {
	
	private String userName;
	
	private String password;
	
	private String email;
	
//	private Set<RoleType> roles=new HashSet<>();

}
