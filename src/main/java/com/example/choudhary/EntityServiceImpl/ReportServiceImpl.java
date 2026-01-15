package com.example.choudhary.EntityServiceImpl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.choudhary.Entity.Leadership;
import com.example.choudhary.Entity.Patient;
import com.example.choudhary.Entity.Report;
import com.example.choudhary.EntityDto.ReportDto;
import com.example.choudhary.EntityRepo.LeadersipRepo;
import com.example.choudhary.EntityRepo.PatientRepo;
import com.example.choudhary.EntityRepo.ReportRepo;
import com.example.choudhary.EntityService.ReportService;

import lombok.RequiredArgsConstructor;
@Service
public class ReportServiceImpl implements ReportService {

	@Autowired
    private  ReportRepo reportRepo;
	@Autowired
    private  PatientRepo patientRepo;
	@Autowired
    private  LeadersipRepo leadershipRepo;

    // ✅ CREATE
    @Override
    public ReportDto createReport(ReportDto dto) {

        Report report = new Report();
        report.setReportName(dto.getReportName());
        report.setReportDate(dto.getReportDate());
        report.setPdfPath(dto.getPdfPath());

        Patient patient = patientRepo.findById(dto.getPatient_Id())
                .orElseThrow(() -> new RuntimeException("Patient not found"));

        Leadership leadership = leadershipRepo.findById(dto.getLeadership_Id())
                .orElseThrow(() -> new RuntimeException("Leadership not found"));

        report.setPatient(patient);
        report.setLeadership(leadership);

        return mapToDto(reportRepo.save(report));
    }

    // ✅ GET ALL
    @Override
    public List<ReportDto> getAllReport() {
        return reportRepo.findAll()
                .stream()
                .map(this::mapToDto)
                .collect(Collectors.toList());
    }

//    // ✅ GET BY ID
//    @Override
//    public ReportDto getReportById(Integer id) {
//        Report report = reportRepo.findById(id)
//                .orElseThrow(() -> new RuntimeException("Report not found"));
//        return mapToDto(report);
//    }

    // ✅ UPDATE
    @Override
    public ReportDto updateReport( Integer rid ,ReportDto dto) {

        Report report = reportRepo.findById(rid)
                .orElseThrow(() -> new RuntimeException("Report not found"));

        report.setReportName(dto.getReportName());
        report.setReportDate(dto.getReportDate());
        report.setPdfPath(dto.getPdfPath());

        
            Patient patient = patientRepo.findById(dto.getPatient_Id())
                    .orElseThrow(() -> new RuntimeException("Patient not found"));
            report.setPatient(patient);
        

//        if (dto.getLeadership_Id() != null) {
            Leadership leadership = leadershipRepo.findById(dto.getLeadership_Id())
                    .orElseThrow(() -> new RuntimeException("Leadership not found"));
            report.setLeadership(leadership);
//        }

        return mapToDto(reportRepo.save(report));
    }

    // ✅ DELETE
    @Override
    public void deleteReport(Integer id) {
        reportRepo.deleteById(id);
    }

    // 🔁 ENTITY → DTO
    private ReportDto mapToDto(Report report) {
        ReportDto dto = new ReportDto();
        dto.setId(report.getId());
        dto.setReportName(report.getReportName());
        dto.setReportDate(report.getReportDate());
        dto.setPdfPath(report.getPdfPath());
        dto.setPatient_Id(report.getPatient().getId());
        dto.setLeadership_Id(report.getLeadership().getLid());
        return dto;
    }
}
