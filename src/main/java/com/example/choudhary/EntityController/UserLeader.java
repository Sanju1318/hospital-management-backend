package com.example.choudhary.EntityController;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.choudhary.EntityDto.LeadershipDto;
import com.example.choudhary.EntityService.FileUpload;
import com.example.choudhary.EntityService.LeadershipService;

import jakarta.servlet.http.HttpServletResponse;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/doctor")
public class UserLeader {

    @Autowired
    private LeadershipService leadershipService;

    @Autowired
    private FileUpload fileUpload;

    @Value("${project.image}")
    private String path;

    // ✅ Get all leaders (JSON)
    @GetMapping
    public List<LeadershipDto> getAllLeader() {
        return leadershipService.gettAllLeader();
    }

    // ✅ Get leader image
    @GetMapping(
        value = "/image/{photoName}",
        produces = MediaType.IMAGE_JPEG_VALUE
    )
    public void getLeaderImage(
            @PathVariable String photoName,
            HttpServletResponse response
    ) throws IOException {

        InputStream stream = fileUpload.getResource(path, photoName);
        response.setContentType(MediaType.IMAGE_JPEG_VALUE);
        StreamUtils.copy(stream, response.getOutputStream());
    }
}
