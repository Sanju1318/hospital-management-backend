package com.example.choudhary.EntityService;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.choudhary.EntityDto.BookAppointmentDto;
import com.example.choudhary.EntityDto.LeadershipDto;
import com.example.choudhary.EntityDto.PatientDto;

public interface BookAppoinmentService {
	
	
	BookAppointmentDto bookedAppoinment(BookAppointmentDto bookAppointmentDto);
	
//	BookAppointmentDto reassignbookedAppoinment(Integer appointmentId,Integer leaderId);
	
	List<BookAppointmentDto> findAll();
	
	BookAppointmentDto getById(Integer bid);
	
	void deleteAppointment(Integer bid);
	

}
