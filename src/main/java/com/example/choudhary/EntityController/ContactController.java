package com.example.choudhary.EntityController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.choudhary.EntityDto.ContactDto;
import com.example.choudhary.EntityService.ContactService;
@CrossOrigin(origins = "http://localhost:3000")

@RestController
@RequestMapping("/user/contact")
public class ContactController {
	
	@Autowired
	private ContactService contactService;
	
	@PostMapping
	public ResponseEntity<ContactDto> createContact(@RequestBody ContactDto contactDto)
	{
		
		ContactDto contactDto2=this.contactService.createContact(contactDto);
		return new ResponseEntity<>(contactDto2,HttpStatus.OK);
				
	}

}
