//package com.example.choudhary;
//
//import java.time.LocalDate;
//
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//
//import com.example.choudhary.Entity.Insurance;
//import com.example.choudhary.Entity.Patient;
//import com.example.choudhary.EntityService.InsuranceService;
//
//@SpringBootTest
//public class InsuranceTest {
//
//    @Autowired
//    private InsuranceService insuranceService;
//
//    @Test
//    public void testInsurance() {
//        Insurance insurance = Insurance.builder()
//                .policyNumber("HDFC_1234")
//                .provider("HDFC")
//                .validUnit(LocalDate.of(2030, 12, 12)) // ✅ fix name
//                .build();
//
//        Patient patient = this.insuranceService.assignInsurence(insurance, 1); // ✅ fix spelling
//        System.out.println("Patient with assigned insurance: " + patient);
//var newPatient=this.insuranceService.insurenceOnlyDelete(patient.getId());
//        
//        System.out.println(newPatient);
//    }
//}
