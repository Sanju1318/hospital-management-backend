package com.example.choudhary.EntityServiceImpl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.choudhary.Entity.Patient;
import com.example.choudhary.EntityDto.PatientDto;
import com.example.choudhary.EntityRepo.PatientRepo;
import com.example.choudhary.EntityService.PatientService;

@Service
public class ServiceImpl implements PatientService {

    @Autowired 
    private PatientRepo patientRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public PatientDto createPatient(PatientDto patientDto) {
        Patient patient = this.modelMapper.map(patientDto, Patient.class);
        Patient savedPatient = this.patientRepo.save(patient);
        return this.modelMapper.map(savedPatient, PatientDto.class);
    }

    @Override
    public List<PatientDto> getPatient() {
        List<Patient> alldata = this.patientRepo.findAll();
        return alldata.stream()
                .map(patient -> this.modelMapper.map(patient, PatientDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public PatientDto updatePatient(PatientDto patientDto, Integer patientId) {
        Patient patient = this.patientRepo.findById(patientId)
                .orElseThrow(() -> new RuntimeException("Patient not found with id: " + patientId));

        patient.setAddress(patientDto.getAddress());
        patient.setAge(patientDto.getAge());
        patient.setMobileNumber(patientDto.getMobileNumber());
        patient.setFee(patientDto.getFee());
        patient.setGender(patientDto.getGender());
        patient.setName(patientDto.getName());

        Patient saveData = this.patientRepo.save(patient);
        return this.modelMapper.map(saveData, PatientDto.class);
    }

    @Override
    public PatientDto getByIdPatient(Integer patientId) {
        Patient patient = this.patientRepo.findById(patientId)
                .orElseThrow(() -> new RuntimeException("Patient not found with id: " + patientId));
        return this.modelMapper.map(patient, PatientDto.class);
    }

    @Override
    public void deleteById(Integer patientId) {
        this.patientRepo.deleteById(patientId);
    }
}
