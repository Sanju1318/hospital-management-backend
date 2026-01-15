package com.example.choudhary.EntityService;

import java.util.List;

import com.example.choudhary.EntityDto.ContactDto;

public interface ContactService {
	
	ContactDto createContact(ContactDto contactDto );
	
	List<ContactDto> gettAllConatct();
	
	void deleteContact(Integer cid);
	
	ContactDto getByIdConatct(Integer cid);

}
