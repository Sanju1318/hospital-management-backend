package com.example.choudhary.EntityController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.choudhary.EntityDto.BookAppointmentDto;
import com.example.choudhary.EntityServiceImpl.BookAppointmentServiceImpl;

@RestController
@RequestMapping("/admin/apnt")
public class AdminAppontment {

	@Autowired
	private BookAppointmentServiceImpl appointmentServiceImpl;
	
	@GetMapping
	public ResponseEntity<List<BookAppointmentDto>> findAllApnd()
	{
		
		List<BookAppointmentDto> dtos=this.appointmentServiceImpl.findAll();
		
		return new ResponseEntity<>(dtos,HttpStatus.OK);
	}
}
