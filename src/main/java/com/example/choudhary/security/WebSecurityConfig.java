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

@Configuration
@EnableMethodSecurity(prePostEnabled = true)
@RequiredArgsConstructor
public class WebSecurityConfig {

    private final JwtAuthFilter jwtAuthFilter;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http
            // ✅ CORS ENABLE
            .cors(Customizer.withDefaults())

            // ✅ CSRF DISABLE (JWT ke liye required)
            .csrf(csrf -> csrf.disable())

            // ✅ STATELESS SESSION
            .sessionManagement(session ->
                session.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
            )

            .authorizeHttpRequests(auth -> auth
                // 🔓 PUBLIC APIs
                .requestMatchers("/auth/**").permitAll()
                .requestMatchers("/user/**").permitAll()

                .requestMatchers(HttpMethod.GET, "/gallary/**").permitAll()
                .requestMatchers(HttpMethod.GET, "/staff/**").permitAll()
                .requestMatchers(HttpMethod.GET, "/doctor/**").permitAll()
                .requestMatchers(HttpMethod.GET, "/report/**").permitAll()

                .requestMatchers(HttpMethod.POST, "/user/contact**").permitAll()
                .requestMatchers(HttpMethod.POST, "/user/apnt**").permitAll()

                // 🔐 ADMIN APIs
                .requestMatchers("/admin/**").hasRole("ADMIN")

                // 🔒 EVERYTHING ELSE
                .anyRequest().authenticated()
            )

            // ✅ JWT FILTER
            .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }

    // ✅ FINAL CORS CONFIG (RENDER + LOCAL)
   @Bean
public CorsConfigurationSource corsConfigurationSource() {

    CorsConfiguration config = new CorsConfiguration();

    // ✅ RENDER ALL SUBDOMAINS ALLOWED
    config.setAllowedOriginPatterns(List.of(
        "http://localhost:3000",
        "https://*.onrender.com"
    ));

    config.setAllowedMethods(List.of(
        "GET", "POST", "PUT", "DELETE", "OPTIONS"
    ));

    config.setAllowedHeaders(List.of("*"));
    config.setAllowCredentials(true);

    UrlBasedCorsConfigurationSource source =
            new UrlBasedCorsConfigurationSource();
    source.registerCorsConfiguration("/**", config);

    return source;
}

}
