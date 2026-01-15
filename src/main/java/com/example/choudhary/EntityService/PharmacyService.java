package com.example.choudhary.EntityService;

import java.util.List;

import org.springframework.stereotype.Service;

//import com.example.choudhary.Entity.Pharmacy;
import com.example.choudhary.EntityDto.PharmacyDto;

@Service
public interface PharmacyService {
	
	
	PharmacyDto addMedicine(PharmacyDto pharmacyDto);
	
	List<PharmacyDto> findAllMedicine();
	
	PharmacyDto updateMedicine(PharmacyDto pharmacyDto,Integer mid);
	
	void medicineRemove(Integer mid);

}
