package com.example.choudhary.EntityController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.choudhary.EntityDto.ReportDto;
import com.example.choudhary.EntityServiceImpl.ReportServiceImpl;


@RestController
@RequestMapping("/admin/report")
public class AdminReportController {
	
	@Autowired
	private ReportServiceImpl reportServiceImpl;
	
	@PostMapping
	public ResponseEntity<ReportDto> createReport(@RequestBody 	ReportDto reportDto)
	{
		ReportDto reportDto2=this.reportServiceImpl.createReport(reportDto);
		return new ResponseEntity<ReportDto>(reportDto2,HttpStatus.CREATED);
	}
	
	@PutMapping
	public ResponseEntity<ReportDto> updateReport(@RequestParam Integer rid, @RequestBody ReportDto reportDto)
	{
		ReportDto dto=this.reportServiceImpl.updateReport(rid,reportDto);
		return new ResponseEntity<ReportDto>(dto,HttpStatus.OK);
	}
	
	@DeleteMapping
	public ResponseEntity<Void> deleteReport(@PathVariable Integer rid)
	{
		this.reportServiceImpl.deleteReport(rid);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
