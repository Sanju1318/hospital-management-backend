package com.example.choudhary.EntityController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.choudhary.EntityDto.ContactDto;
import com.example.choudhary.EntityService.ContactService;

@RestController
@RequestMapping("/admin/contact")
public class AdminContact {
	
	@Autowired
	private ContactService contactService;
	
//	@PostMapping
//	public ResponseEntity<ContactDto> createContact(@RequestBody ContactDto contactDto)
//	{
//		
//		ContactDto contactDto2=this.contactService.createContact(contactDto);
//		return new ResponseEntity<>(contactDto2,HttpStatus.OK);
//				
//	}
	
	@GetMapping
	public ResponseEntity<List<ContactDto>> findAllContact()
	{
		List<ContactDto> list   =this.contactService.gettAllConatct();
		return new ResponseEntity<>(list,HttpStatus.OK);
		
	}

}
