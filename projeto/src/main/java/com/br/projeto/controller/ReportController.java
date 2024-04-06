package com.br.projeto.controller;

import com.br.projeto.dto.report.ReportRequestDTO;
import com.br.projeto.dto.report.ReportResponseDTO;
import com.br.projeto.entity.Report;
import com.br.projeto.service.ReportServiceImpl;
import com.br.projeto.utils.MapperUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/v1/reports")
public class ReportController {

    private final MapperUtils mapperUtils = new MapperUtils();

    private final ReportServiceImpl reportService;

    public ReportController(ReportServiceImpl reportService) {
        this.reportService = reportService;
    }

    @GetMapping
    public ResponseEntity<Page<ReportResponseDTO>> createReport(Pageable pageable) {
        Page<Report> reports = reportService.getAllReportsByUser(pageable);
        Page<ReportResponseDTO> response = mapperUtils.mapEntityPageIntoDtoPage(reports, ReportResponseDTO.class);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PostMapping
    public ResponseEntity<ReportResponseDTO> createReport(@RequestBody ReportRequestDTO reportRequestDTO) {
        Report createdReport = reportService.createReport(reportRequestDTO);
        ReportResponseDTO response = mapperUtils.map(createdReport, ReportResponseDTO.class);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}