package com.example.choudhary.EntityServiceImpl;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.choudhary.Entity.BookAppointment;
import com.example.choudhary.Entity.Leadership;
import com.example.choudhary.EntityDto.BookAppointmentDto;
import com.example.choudhary.EntityRepo.BookAppointmentRepo;
import com.example.choudhary.EntityRepo.LeadersipRepo;
import com.example.choudhary.EntityService.BookAppoinmentService;

import jakarta.transaction.Transactional;
@Service
public class BookAppointmentServiceImpl implements BookAppoinmentService {

    @Autowired
    private BookAppointmentRepo appointmentRepo;

    @Autowired
    private LeadersipRepo leadershipRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    @Transactional
    public BookAppointmentDto bookedAppoinment(BookAppointmentDto dto) {

        // 1️⃣ Doctor fetch
        Leadership doctor = leadershipRepo.findById(dto.getLeadershipId())
                .orElseThrow(() -> new RuntimeException("Invalid Doctor ID"));

        // 2️⃣ String → LocalDate
        LocalDate date = LocalDate.parse(dto.getAdddate()); // YYYY-MM-DD

        // 3️⃣ String → LocalTime
        LocalTime time = LocalTime.parse(dto.getAppointmentTime()); // HH:mm

        // 4️⃣ Create Entity
        BookAppointment appointment = new BookAppointment();
        appointment.setName(dto.getName());
        appointment.setEmail(dto.getEmail());
        appointment.setPhone(dto.getPhone());

        // 🔥 MOST IMPORTANT FIX
        appointment.setDate(date);     // ✅ FIX
        appointment.setTime(time);     // ✅ FIX
        appointment.setLeadership(doctor);

        // 5️⃣ Save
        BookAppointment saved = appointmentRepo.save(appointment);

        // 6️⃣ Return DTO
        BookAppointmentDto responseDto = modelMapper.map(saved, BookAppointmentDto.class);
        responseDto.setLeadershipId(doctor.getLid());

        return responseDto;
    }

    @Override
    public List<BookAppointmentDto> findAll() {
        return appointmentRepo.findAll().stream()
                .map(a -> {
                    BookAppointmentDto dto = modelMapper.map(a, BookAppointmentDto.class);
                    dto.setLeadershipId(a.getLeadership().getLid());
                    return dto;
                })
                .collect(Collectors.toList());
    }

    @Override
    public BookAppointmentDto getById(Integer appointmentId) {
        BookAppointment appointment = appointmentRepo.findById(appointmentId)
                .orElseThrow(() -> new RuntimeException("Appointment not found"));

        BookAppointmentDto dto = modelMapper.map(appointment, BookAppointmentDto.class);
        dto.setLeadershipId(appointment.getLeadership().getLid());
        return dto;
    }

    @Override
    public void deleteAppointment(Integer appointmentId) {
        BookAppointment appointment = appointmentRepo.findById(appointmentId)
                .orElseThrow(() -> new RuntimeException("Appointment not found"));
        appointmentRepo.delete(appointment);
    }
}
