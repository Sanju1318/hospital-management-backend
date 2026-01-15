package com.example.choudhary.EntityService;

import com.example.choudhary.Entity.Insurance;
import com.example.choudhary.Entity.Patient;

public interface InsuranceService {
	
	Patient assignInsurence(Insurance insurance,Integer patientId);
	
	Patient insurenceOnlyDelete(Integer patientId);

}
