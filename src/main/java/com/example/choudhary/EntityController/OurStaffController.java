package com.example.choudhary.EntityController;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.choudhary.EntityDto.OurStaffDto;
//import com.example.choudhary.EntityDto.PostDto;
import com.example.choudhary.EntityService.FileUpload;
import com.example.choudhary.EntityService.OurStaffService;

import jakarta.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/staff")
@CrossOrigin(origins = "http://localhost:3000")
public class OurStaffController {

    @Autowired
    private OurStaffService ourStaffService;

    @Autowired
    private FileUpload fileUpload;

    @Value("${project.image}")
    private String path;

    @GetMapping
    public List<OurStaffDto> getAllStaff() {
        return ourStaffService.FindData();
    }

    @GetMapping("/image/{imageName}")
    public void getStaffImage(
            @PathVariable String imageName,
            HttpServletResponse response) throws IOException {

        InputStream is = fileUpload.getResource(path, imageName);
        response.setContentType("image/jpeg");
        StreamUtils.copy(is, response.getOutputStream());
    }
}
