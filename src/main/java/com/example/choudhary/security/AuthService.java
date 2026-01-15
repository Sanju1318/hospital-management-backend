//package com.example.choudhary.security;
//
//
//import java.util.Set;
//
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.stereotype.Service;
//
//import com.example.choudhary.Entity.Patient;
//import com.example.choudhary.Entity.User;
//import com.example.choudhary.EntityDto.LoginRequestDto;
//import com.example.choudhary.EntityDto.LoginResponseDto;
//import com.example.choudhary.EntityDto.SignResponseDto;
//import com.example.choudhary.EntityDto.SignUpRequestDto;
//import com.example.choudhary.EntityRepo.PatientRepo;
//import com.example.choudhary.EntityRepo.UserRepo;
//import com.example.choudhary.Type.RoleType;
//
//import lombok.RequiredArgsConstructor;
//
//@Service
//@RequiredArgsConstructor
//public class AuthService {
//
//	private final AuthenticationManager authenticationManager;
//
//	private final AuthUtil authUtil;
//	
//	private final UserRepo userRepo;
//	
//	private final PasswordEncoder passwordEncoder;
//	
//	private final PatientRepo patientRepo;
//	
//	public LoginResponseDto login(LoginRequestDto loginRequestDto) {
//		// TODO Auto-generated method stub
//		Authentication authentication= authenticationManager.authenticate(
//				new UsernamePasswordAuthenticationToken(loginRequestDto.getUserName(), loginRequestDto.getPassword()));
//		User user= (User) authentication.getPrincipal();
//		
//		String token=authUtil.generateAccessToken(user);
//		
//		return new LoginResponseDto(token,user.getId());
//	}
//	public User siGnUp(SignUpRequestDto signUpRequestDto) {
//		// TODO Auto-generated method stub
//		User user=userRepo.findByUserName(signUpRequestDto.getUserName()).orElse(null);
//		if(user!=null) throw
//		new IllegalArgumentException("User Already exsist");
//		
//		user=userRepo.save(User.builder()
//				.userName(signUpRequestDto.getUserName())
//				.password(passwordEncoder.encode(signUpRequestDto.getPassword()))
//				.roleTypes(signUpRequestDto.getRoles())//Role.Patient
//				.build()
//				);
//		
//		Patient patient=Patient.builder()
//				.name(signUpRequestDto.getName())
//				.mobileNumber(signUpRequestDto.getUserName())
//				.user(user).build();
//		
//		patientRepo.save(patient);
//		return user;
//	}
//
//}
