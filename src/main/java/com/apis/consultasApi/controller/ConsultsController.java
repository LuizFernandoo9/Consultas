package com.apis.consultasApi.controller;

import java.net.ResponseCache;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyEmitter;

import com.apis.consultasApi.dtos.ConsultPatientsRequestDto;
import com.apis.consultasApi.dtos.ExamRequestDTO;
import com.apis.consultasApi.service.ConsultService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/Consulta")
public class ConsultsController {

    @Autowired
    private ConsultService consultService;

    @GetMapping("/patient")
    public ResponseEntity<Object> getPatient(@Valid @RequestBody ConsultPatientsRequestDto consultPatientsRequestDto){
        try {
            var getPatients = this.consultService.getPatients(consultPatientsRequestDto);
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(getPatients);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @GetMapping("/exams")
    public ResponseEntity<Object> getExam(@RequestBody ExamRequestDTO examRequestDTO){
        try {
            var getExams = this.consultService.getExams(examRequestDTO);
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(getExams);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
}
