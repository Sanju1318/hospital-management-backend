package com.example.choudhary.EntityService;

import java.util.List;

import com.example.choudhary.EntityDto.ReportDto;

public interface ReportService {
	
	
	ReportDto createReport(ReportDto reportDto);
	
	List<ReportDto> getAllReport();
	
	ReportDto updateReport(Integer rid,ReportDto reportDto);
	
	void deleteReport(Integer rid);

}
