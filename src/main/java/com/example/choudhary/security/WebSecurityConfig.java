package com.example.choudhary.security;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import lombok.RequiredArgsConstructor;

@EnableMethodSecurity(prePostEnabled = true)
@Configuration
@RequiredArgsConstructor
public class WebSecurityConfig {

    private final JwtAuthFilter jwtAuthFilter;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http
            // ✅ VERY IMPORTANT
            .cors(Customizer.withDefaults())

            .csrf(csrf -> csrf.disable())

            .sessionManagement(session -> session
                    .sessionCreationPolicy(SessionCreationPolicy.STATELESS))

            .authorizeHttpRequests(auth -> auth
            	    .requestMatchers("/auth/**").permitAll()
            	    .requestMatchers("/user/**").permitAll()   // ✅ CHANGE
            	    .requestMatchers("/admin/**").hasRole("ADMIN")
            	                       .requestMatchers(HttpMethod.GET, "/gallary/**").permitAll()
                    .requestMatchers(HttpMethod.GET, "/staff/**").permitAll()
                    .requestMatchers(HttpMethod.GET, "/doctor/**").permitAll()
                    .requestMatchers(HttpMethod.GET, "/report/**").permitAll()
                    
                    .requestMatchers(HttpMethod.POST, "/user/contact**").permitAll()
                    .requestMatchers(HttpMethod.GET, "/admin/contact/**").hasRole("ADMIN")
                    .requestMatchers(HttpMethod.POST, "/user/apnt**").permitAll()
                    .requestMatchers(HttpMethod.GET, "/admin/apnt/**").hasRole("ADMIN")

                    .requestMatchers(HttpMethod.POST, "/admin/report/**").hasRole("ADMIN")
                    .requestMatchers(HttpMethod.POST, "/admin/doctor/**").hasRole("ADMIN")
                    .requestMatchers(HttpMethod.POST, "/admin/staff/**").hasRole("ADMIN")
                    .requestMatchers(HttpMethod.POST, "/admin/gallary/**").hasRole("ADMIN")
            	    .requestMatchers(HttpMethod.POST,"/admin/newpatient/**").hasRole("ADMIN")
            	    .requestMatchers(HttpMethod.POST,"/admin/pharmacy/**").hasRole("ADMIN")
            	    .anyRequest().authenticated()
            	)

            .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }

    // ✅ GLOBAL CORS CONFIG
    @Bean
    public CorsConfigurationSource corsConfigurationSource() {

        CorsConfiguration config = new CorsConfiguration();
        config.setAllowedOrigins(List.of("http://localhost:3000"));
        config.setAllowedMethods(List.of("GET", "POST", "PUT", "DELETE", "OPTIONS"));
        config.setAllowedHeaders(List.of("*"));
        config.setAllowCredentials(true);

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", config);

        return source;
    }
}
