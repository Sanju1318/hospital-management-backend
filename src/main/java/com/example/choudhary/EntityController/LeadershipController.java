package com.example.choudhary.EntityController;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.bind.annotation.RequestPart;

import com.example.choudhary.EntityDto.LeadershipDto;
import com.example.choudhary.EntityService.FileUpload;
import com.example.choudhary.EntityService.LeadershipService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/admin/doctor")
public class LeadershipController {

    @Autowired
    private LeadershipService leadershipService;

    @Autowired
    private FileUpload fileUpload;

    @Value("${project.image}")
    private String path;

    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<LeadershipDto> createLeader(
            @RequestPart("image") MultipartFile image,
            @RequestPart("lname") String lname,
            @RequestPart("lqualification") String lqualification
    ) throws IOException {

        LeadershipDto dto = new LeadershipDto();
        dto.setLname(lname);
        dto.setLqualification(lqualification);

        String filename = fileUpload.uploadImage(path, image);
        dto.setLphoto(filename);

        LeadershipDto saved = leadershipService.addLeader(dto);
        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }

}
