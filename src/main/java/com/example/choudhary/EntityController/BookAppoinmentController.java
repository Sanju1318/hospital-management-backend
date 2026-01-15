package com.example.choudhary.EntityController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.choudhary.EntityDto.BookAppointmentDto;
import com.example.choudhary.EntityService.BookAppoinmentService;
@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/user/apnt")
public class BookAppoinmentController {
	
	@Autowired
	private BookAppoinmentService bookAppoinmentService;
	
	@PostMapping
	public ResponseEntity<BookAppointmentDto> addPatient(@RequestBody BookAppointmentDto bookAppointmentDto)
	{
		BookAppointmentDto bookAppointmentDto2=this.bookAppoinmentService.bookedAppoinment(bookAppointmentDto);
		return new ResponseEntity<>(bookAppointmentDto2,HttpStatus.OK);
	}

}
