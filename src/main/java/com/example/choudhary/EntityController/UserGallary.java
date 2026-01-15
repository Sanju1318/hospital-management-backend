package com.example.choudhary.EntityController;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.*;

import com.example.choudhary.EntityDto.GallaryDto;
import com.example.choudhary.EntityService.FileUpload;
import com.example.choudhary.EntityService.GallaryService;
import com.example.choudhary.EntityServiceImpl.GallaryServiceImpl;

import jakarta.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/gallary")
@CrossOrigin(origins = "http://localhost:3000")
public class UserGallary {

    @Autowired
    private GallaryServiceImpl gallaryService;

    @Autowired
    private FileUpload fileUpload;

    @Value("${project.image}")
    private String path;

    // ✅ USER: View gallery list
    @GetMapping
    public ResponseEntity<List<GallaryDto>> getAllGallery() {
        return ResponseEntity.ok(gallaryService.getAllGallary());
    }

    // ✅ USER: View image
    @GetMapping(value = "/image/{imageName}", produces = MediaType.IMAGE_JPEG_VALUE)
    public void getImage(
            @PathVariable String imageName,
            HttpServletResponse response) throws IOException {

        InputStream is = fileUpload.getResource(path, imageName);
        response.setContentType(MediaType.IMAGE_JPEG_VALUE);
        StreamUtils.copy(is, response.getOutputStream());
    }
}
