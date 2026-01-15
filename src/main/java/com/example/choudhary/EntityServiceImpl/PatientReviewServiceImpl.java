package com.example.choudhary.EntityServiceImpl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.choudhary.Entity.PatientReview;
import com.example.choudhary.EntityDto.PatientReviewDto;
import com.example.choudhary.EntityRepo.PatientReviewRepo;
import com.example.choudhary.EntityService.PatientReviewService;

@Service
public class PatientReviewServiceImpl implements PatientReviewService {

	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private PatientReviewRepo patientReviewRepo;
	@Override
	public PatientReviewDto createReview(PatientReviewDto patientDto) {
		// TODO Auto-generated method stub
		PatientReview patientReview=this.modelMapper.map(patientDto, PatientReview.class);
		PatientReview AllReviewSave=this.patientReviewRepo.save(patientReview);
		return this.modelMapper.map(AllReviewSave, PatientReviewDto.class);
	}

	@Override
	public List<PatientReviewDto> findAllreview() {
		// TODO Auto-generated method stub
		List<PatientReview> patientReviews=this.patientReviewRepo.findAll();
		List<PatientReviewDto> patientReviewDtos =patientReviews.stream().map((reviews)->
		this.modelMapper.map(reviews,PatientReviewDto.class)).collect(Collectors.toList());
		return patientReviewDtos;
	}
	@Override
	public Page<PatientReviewDto> getPaginatedReviews(Pageable pageable) {
	    Page<PatientReview> reviewsPage = this.patientReviewRepo.findAll(pageable);
	    return reviewsPage.map(review -> this.modelMapper.map(review, PatientReviewDto.class));
	}



}
