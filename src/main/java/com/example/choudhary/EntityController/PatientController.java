package com.example.choudhary.EntityController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import com.example.choudhary.EntityDto.PatientDto;
import com.example.choudhary.EntityServiceImpl.ServiceImpl;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/admin/newpatient")
public class PatientController {

    @Autowired
    private ServiceImpl serviceImpl;

    // ✅ Admin-only create patient
    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public PatientDto createPatient(@RequestBody PatientDto patientDto) {
        return serviceImpl.createPatient(patientDto);
    }

    // ✅ Anyone authenticated can view patients
    @GetMapping("/landing")
    @PreAuthorize("isAuthenticated()")
    public List<PatientDto> getAllPatients() {
        return serviceImpl.getPatient();
    }

    // ✅ Admin-only update patient
    @PutMapping("/update/{patientId}")
    @PreAuthorize("hasRole('ADMIN')")
    public PatientDto updatePatient(@RequestBody PatientDto patientDto, @PathVariable Integer patientId) {
        PatientDto updatedData = serviceImpl.updatePatient(patientDto, patientId);
        if (updatedData == null) {
            throw new RuntimeException("Patient not found with id: " + patientId);
        }
        return updatedData;
    }
}
