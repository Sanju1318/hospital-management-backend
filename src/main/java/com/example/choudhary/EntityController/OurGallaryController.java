package com.example.choudhary.EntityController;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.example.choudhary.EntityDto.GallaryDto;
import com.example.choudhary.EntityService.FileUpload;
import com.example.choudhary.EntityService.GallaryService;

import jakarta.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/admin/gallary")
@CrossOrigin(origins = "http://localhost:3000")
public class OurGallaryController {

    @Autowired
    private GallaryService gallaryService;

    @Autowired
    private FileUpload fileUpload;

    @Value("${project.image}")
    private String path;

    // ✅ GET ALL IMAGES (DB DATA)
    @GetMapping
    public ResponseEntity<List<GallaryDto>> getAllGallery() {
        return ResponseEntity.ok(gallaryService.getAllGallary());
    }

    // ✅ GET IMAGE FILE
    @GetMapping(
        value = "/image/{imageName}",
        produces = MediaType.IMAGE_JPEG_VALUE
    )
    public void getImage(
            @PathVariable String imageName,
            HttpServletResponse response) throws IOException {

        InputStream is = fileUpload.getResource(path, imageName);
        response.setContentType(MediaType.IMAGE_JPEG_VALUE);
        StreamUtils.copy(is, response.getOutputStream());
    }

    // ✅ POST IMAGE (UPLOAD)
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<GallaryDto> uploadImage(
            @RequestParam("image") MultipartFile image,
            @RequestParam("title") String title
    ) throws IOException {

        // 1️⃣ Upload image to folder
        String fileName = fileUpload.uploadImage(path, image);

        // 2️⃣ Save data in DB
        GallaryDto gallaryDto = new GallaryDto();
        gallaryDto.setGallaryName(title);
        gallaryDto.setRname(fileName);

        GallaryDto saved = gallaryService.AddGallary(gallaryDto);

        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }
}
