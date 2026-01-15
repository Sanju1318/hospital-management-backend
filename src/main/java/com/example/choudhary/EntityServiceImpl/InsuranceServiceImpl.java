package com.example.choudhary.EntityServiceImpl;

import org.springframework.stereotype.Service;

import com.example.choudhary.Entity.Insurance;
import com.example.choudhary.Entity.Patient;
import com.example.choudhary.EntityRepo.InsuranceRepo;
import com.example.choudhary.EntityRepo.PatientRepo;
import com.example.choudhary.EntityService.InsuranceService;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class InsuranceServiceImpl implements InsuranceService {

	
	private final PatientRepo patientRepo;
	
	private final InsuranceRepo insuranceRepo;
	
	@Transactional
	@Override
	public Patient assignInsurence(Insurance insurance, Integer patientId) {
		// TODO Auto-generated method stub
		Patient patient=patientRepo.findById(patientId).orElseThrow(()->new EntityNotFoundException("Patient Not found "+patientId));
		patient.setInsurance(insurance);
		insurance.setPatient(patient);
		return patient;
	}
	@Transactional
	@Override
	public Patient insurenceOnlyDelete(Integer patientId) {
		// TODO Auto-generated method stub
		
		Patient patient=patientRepo.findById(patientId).orElseThrow(()->new EntityNotFoundException("Not foud"+patientId));
		patient.setInsurance(null);
        
		return patient;
	}


}
