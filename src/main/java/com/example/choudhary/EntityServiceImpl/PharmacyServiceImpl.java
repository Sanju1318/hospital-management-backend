package com.example.choudhary.EntityServiceImpl;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.example.choudhary.Entity.Pharmacy;
import com.example.choudhary.EntityDto.PharmacyDto;
import com.example.choudhary.EntityRepo.PharmacyRepo;
import com.example.choudhary.EntityService.PharmacyService;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
//@AllArgsConstructor
public class PharmacyServiceImpl implements PharmacyService {
	
	private final PharmacyRepo pharmacyRepo;
	
	private final ModelMapper modelMapper;

	@Override
	public PharmacyDto addMedicine(PharmacyDto pharmacyDto) {
		// TODO Auto-generated method stub
		
		Pharmacy pharmacy=this.modelMapper.map(pharmacyDto, Pharmacy.class);
		Pharmacy savePharmacy=this.pharmacyRepo.save(pharmacy);
		return this.modelMapper.map(savePharmacy, PharmacyDto.class);
	}

	@Override
	public List<PharmacyDto> findAllMedicine() {
		// TODO Auto-generated method stub
		
		List<Pharmacy> pharmacies=this.pharmacyRepo.findAll();
		return pharmacies.stream().map(data-> this.modelMapper.map(data,PharmacyDto.class)).collect(Collectors.toList());
	}

	@Override
	public PharmacyDto updateMedicine(PharmacyDto pharmacyDto,Integer mid) {
		// TODO Auto-generated method stub
		
		Pharmacy pharmacy=this.pharmacyRepo.findById(mid).orElseThrow();
		
		 pharmacy.setName(pharmacyDto.getName());
		 pharmacy.setCategory(pharmacyDto.getCategory());
		 pharmacy.setPrice(pharmacyDto.getPrice());
		 pharmacy.setStock(pharmacyDto.getStock());
		 Pharmacy pharmacy2=this.pharmacyRepo.save(pharmacy);
		return this.modelMapper.map(pharmacy2, PharmacyDto.class);
	}

	@Override
	public void medicineRemove(Integer mid) {
		// TODO Auto-generated method stub
		this.pharmacyRepo.deleteById(mid);
		
	}

}
