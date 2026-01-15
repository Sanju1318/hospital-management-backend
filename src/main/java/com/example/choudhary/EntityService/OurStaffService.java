package com.example.choudhary.EntityService;

import java.util.List;

import com.example.choudhary.EntityDto.OurStaffDto;

public interface OurStaffService {
    
//    // --- Methods from FileService ---
//    String uploadImage(String path, MultipartFile file) throws IOException;
//    InputStream getResource(String path, String filename) throws FileNotFoundException;

    // --- Methods from OurStaffService ---
    OurStaffDto AddStaff(OurStaffDto ourStaffDto);
    
    OurStaffDto AddImage(OurStaffDto ourStaffDto ,Integer staffId);

    
    List<OurStaffDto> FindData();
    
    void DeleteStaff();
    
    OurStaffDto UpdateStaff(OurStaffDto ourStaffDto, Integer staffId);
    
    OurStaffDto GetById(Integer staffId);
}
