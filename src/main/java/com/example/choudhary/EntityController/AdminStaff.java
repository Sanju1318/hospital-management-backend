package com.example.choudhary.EntityController;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.choudhary.EntityDto.OurStaffDto;
import com.example.choudhary.EntityService.FileUpload;
import com.example.choudhary.EntityService.OurStaffService;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping("/admin/staff")
@CrossOrigin(origins = "http://localhost:3000")
public class AdminStaff {

    @Autowired
    private OurStaffService ourStaffService;

    @Autowired
    private FileUpload fileUpload;

    @Value("${project.image}")
    private String path;

    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<OurStaffDto> addStaff(
            @RequestParam("staff") String staffJson,
            @RequestParam("image") MultipartFile image
    ) throws IOException {

        // 1️⃣ JSON → DTO
        ObjectMapper mapper = new ObjectMapper();
        OurStaffDto staffDto = mapper.readValue(staffJson, OurStaffDto.class);

        // 2️⃣ Save staff without image
        OurStaffDto savedStaff = ourStaffService.AddStaff(staffDto);

        // 3️⃣ Upload image
        String fileName = fileUpload.uploadImage(path, image);
        savedStaff.setImagename(fileName);

        // 4️⃣ Update staff with image
        OurStaffDto finalStaff =
                ourStaffService.AddImage(savedStaff, savedStaff.getStaffId());

        return new ResponseEntity<>(finalStaff, HttpStatus.CREATED);
    }
}
