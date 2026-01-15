package com.example.choudhary.EntityController;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.example.choudhary.EntityDto.*;
import com.example.choudhary.EntityService.*;

import jakarta.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/user")
public class UserController {

	@GetMapping("/landing")
	public ResponseEntity<Map<String, String>> landing() {
	    Map<String, String> res = new HashMap<>();
	    res.put("message", "User Landing Page OK");
	    return ResponseEntity.ok(res);
	}}

