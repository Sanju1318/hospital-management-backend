package com.example.choudhary.EntityService;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.example.choudhary.EntityDto.PatientReviewDto;

public interface PatientReviewService {
	
	PatientReviewDto createReview(PatientReviewDto patientDto);
	
	List<PatientReviewDto> findAllreview();
	
	Page<PatientReviewDto> getPaginatedReviews(Pageable pageable) ;

}
