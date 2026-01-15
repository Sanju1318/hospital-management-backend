package com.example.choudhary.EntityController;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.choudhary.Entity.User;
import com.example.choudhary.EntityDto.LoginRequestDto;
import com.example.choudhary.EntityDto.LoginResponseDto;
import com.example.choudhary.EntityDto.SignResponseDto;
import com.example.choudhary.EntityDto.SignUpRequestDto;
//import com.example.choudhary.security.AuthService;
import com.example.choudhary.EntityRepo.UserRepo;
import com.example.choudhary.security.AuthUtil;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
//@CrossOrigin(origins = "http://localhost:3000")
public class AuthController {

    private final UserRepo userRepo;
    private final PasswordEncoder passwordEncoder;
    private final AuthUtil authUtil;

    // SIGNUP
    @PostMapping("/signup")
    public ResponseEntity<?> signup(@RequestBody SignUpRequestDto dto) {

        if (userRepo.findByUserName(dto.getUserName()).isPresent()) {
            return ResponseEntity.badRequest().body("Username already exists");
        }

        User user = new User();
        user.setUserName(dto.getUserName());
        user.setEmail(dto.getEmail());
        user.setPassword(passwordEncoder.encode(dto.getPassword()));
        user.setRole("USER");

        userRepo.save(user);

        return ResponseEntity.ok("Signup Successful");
    }

    // LOGIN
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequestDto dto) {

        User user = userRepo.findByUserName(dto.getUserName())
                .orElseThrow(() -> new RuntimeException("User not found"));

        if (!passwordEncoder.matches(dto.getPassword(), user.getPassword())) {
            return ResponseEntity.status(401).body("Invalid Credentials");
        }

        String token = authUtil.generateAccessToken(user);

        return ResponseEntity.ok(
                Map.of(
                        "token", token,
                        "role", user.getRole()
                )
        );
    }
}
