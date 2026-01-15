package com.example.choudhary.EntityController;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.choudhary.EntityDto.ReportDto;
import com.example.choudhary.EntityService.FileUpload;
import com.example.choudhary.EntityService.ReportService;

import jakarta.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/report")
public class UserReportController {

    @Autowired
    private FileUpload fileUpload;

    @Value("${project.image}")
    private String path;

    @Autowired
    private ReportService reportService;

    // ✅ GET ALL REPORTS
    @GetMapping
    public ResponseEntity<List<ReportDto>> findAllReport() {
        List<ReportDto> list = reportService.getAllReport();
        return ResponseEntity.ok(list);
    }

    // ✅ DOWNLOAD / VIEW PDF
    @GetMapping("/pdf/{fileName}")
    public void downloadPdf(
            @PathVariable String fileName,
            HttpServletResponse response) throws IOException {

        InputStream is = fileUpload.getResource(path, fileName);

        response.setContentType("application/pdf");
        response.setHeader(
                "Content-Disposition",
                "inline; filename=\"" + fileName + "\""
        );

        StreamUtils.copy(is, response.getOutputStream());
        response.flushBuffer();
    }
}
