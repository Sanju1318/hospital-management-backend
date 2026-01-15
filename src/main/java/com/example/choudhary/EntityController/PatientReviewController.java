package com.example.choudhary.EntityController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.choudhary.EntityDto.PatientDto;
import com.example.choudhary.EntityDto.PatientReviewDto;
import com.example.choudhary.EntityService.PatientReviewService;
@RestController
@RequestMapping("/user/review")
@CrossOrigin(origins = "http://localhost:3000")
public class PatientReviewController {

    @Autowired
    private PatientReviewService patientReviewService;

    @PostMapping
    public ResponseEntity<PatientReviewDto> addReview(
            @RequestBody PatientReviewDto dto) {

        return ResponseEntity.ok(patientReviewService.createReview(dto));
    }

    @GetMapping
    public List<PatientReviewDto> getAllReviews() {
        return patientReviewService.findAllreview();
    }

    @GetMapping("/page")
    public Page<PatientReviewDto> getReviews(Pageable pageable) {
        return patientReviewService.getPaginatedReviews(pageable);
    }
}
