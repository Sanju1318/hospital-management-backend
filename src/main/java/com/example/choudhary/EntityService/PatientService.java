package com.example.choudhary.EntityService;

import java.util.List;

import com.example.choudhary.EntityDto.PatientDto;

public interface PatientService {
	
	
	//create Patient deatil
	
	public PatientDto createPatient(PatientDto patientDto);
	
	
	//get  patient
	
	public List<PatientDto> getPatient();
	
	
	//update
	public PatientDto updatePatient(PatientDto patientDto ,Integer patientId);
	
	//GetBY ID
	
	public PatientDto getByIdPatient(Integer patientId);
	
	//delete by id Pateint
	
	public void deleteById(Integer patientId);

}
