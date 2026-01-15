package com.example.choudhary.EntityService;

import java.util.List;

import com.example.choudhary.EntityDto.GallaryDto;

public interface GallaryService {
	
	GallaryDto AddGallary(GallaryDto gallaryDto);
	
	List<GallaryDto> getAllGallary();
	
	GallaryDto upadteGallary(GallaryDto gallaryDto,Integer gId);
	
	void deleteGallary();

}
