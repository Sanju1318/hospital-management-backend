package com.example.choudhary.EntityController;

import java.net.http.HttpResponse;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.choudhary.Entity.Pharmacy;
import com.example.choudhary.EntityDto.PharmacyDto;
import com.example.choudhary.EntityServiceImpl.PharmacyServiceImpl;

import lombok.RequiredArgsConstructor;
//@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/admin/pharmacy")
public class PharmacyController {

    @Autowired
    private PharmacyServiceImpl pharmacyServiceImpl;

    // ✅ ADD MEDICINE
    @PostMapping
    // @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<PharmacyDto> createMedicine(
            @RequestBody PharmacyDto pharmacyDto) {

        PharmacyDto saved = pharmacyServiceImpl.addMedicine(pharmacyDto);
        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }

    // ✅ GET ALL MEDICINES (MAIN FIX)
    @GetMapping
    public ResponseEntity<List<PharmacyDto>> getAllMedicine() {

        List<PharmacyDto> list = pharmacyServiceImpl.findAllMedicine();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    // ✅ UPDATE
    @PutMapping("/{mid}")
    public ResponseEntity<PharmacyDto> updateMedicine(
            @RequestBody PharmacyDto pharmacyDto,
            @RequestParam Integer mid) {

        PharmacyDto updated = pharmacyServiceImpl.updateMedicine(pharmacyDto, mid);
        return new ResponseEntity<>(updated, HttpStatus.OK);
    }

    // ✅ DELETE
    @DeleteMapping("/{mid}")
    public ResponseEntity<Void> deleteMedicine(@RequestParam Integer mid) {

        pharmacyServiceImpl.medicineRemove(mid);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
