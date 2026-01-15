package com.example.choudhary;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@SpringBootApplication
public class HostpitalManagementSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(HostpitalManagementSystemApplication.class, args);
		
		System.out.println("DB Server On");
	}
	@Bean
	public ModelMapper modelMapper()
	{
		return new ModelMapper();
	}
	
	@Bean
	public PasswordEncoder passwordEncoder()
	{
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public AuthenticationManager authenticationManager(AuthenticationConfiguration configuration) throws Exception
	{
		 return configuration.getAuthenticationManager();
	}
//	@Bean
//	public UserDetailsService userDetailsService()
//	{
//		System.out.println("Detail");
//		UserDetails user1=User.withUsername("admin").password(passwordEncoder().encode("pass"))
//				.roles("ADMIN")
//				.build();
//		
//		UserDetails user2=User.withUsername("patient").password(passwordEncoder().encode("pass"))
//				.roles("PATIENT").build();
//		
//		return new InMemoryUserDetailsManager(user1,user2);
//	}

}
