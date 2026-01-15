package com.example.choudhary;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.choudhary.Entity.BookAppointment;
import com.example.choudhary.Entity.Insurance;
import com.example.choudhary.Entity.Patient;
import com.example.choudhary.EntityDto.BookAppointmentDto;
import com.example.choudhary.EntityDto.PatientDto;
import com.example.choudhary.EntityRepo.PatientRepo;
import com.example.choudhary.EntityService.BookAppoinmentService;
import com.example.choudhary.EntityService.InsuranceService;

@SpringBootTest(classes = HostpitalManagementSystemApplication.class) // ✅ Explicitly specify main class
class HostpitalManagementSystemApplicationTests {

    @Autowired
    private InsuranceService insuranceService;
    @Autowired
    private BookAppoinmentService bookAppoinmentService;
    
    @Autowired 
    private PatientRepo patientRepo;

    @Test
    void testInsurance() {
    	Insurance insurance = Insurance.builder()
    	        .policyNumber("HCdmvj_1234")
    	        .provider("HDFC")
    	        .validUnit(LocalDate.of(2030, 12, 12))
    	        .build();

////    	var patient = this.insuranceService.assignInsurence(insurance, 1);
//
////        Insurance insurance = Insurance.builder()
////                .policyNumber("HDFC_1234")
////                .provider("HDFC")
////                .validUnit(LocalDate.of(2030, 12, 12)) // ✅ fixed field name
////                .build();
////
       var patient = this.insuranceService.assignInsurence(insurance, 11); // ✅ fixed method name
////        System.out.println("✅ Patient with assigned insurance: " + patient);
//    	Patient patient=new Patient();
//    	patient.setInsurance(insurance);
//    	System.out.println(patient.getInsurance());
    	System.out.println(patient.getId());
//        
        Patient newPatient=this.insuranceService.insurenceOnlyDelete(11);
        
        System.out.println(newPatient.getId());
    }
    
    @Test
    void testAppointment()
    {
    	List<Patient> dtos=this.patientRepo.findAllpatientWithAppoinment();
    	System.out.println(dtos);
//    	BookAppointmentDto bookAppointmentDto=BookAppointmentDto.builder().adddate(LocalDateTime.of(2025, 12, 1, 12, 00)).message("CA").build();
//    	
//    	var newdata=bookAppoinmentService.bookedAppoinment(bookAppointmentDto, 1, 2);
//    	System.out.println(newdata);
//    	
//    	var updateAppoinment=bookAppoinmentService.reassignbookedAppoinment(newdata.getId(), 3);
//    	
//    	System.out.println(updateAppoinment);
    	

    			
    }
}
