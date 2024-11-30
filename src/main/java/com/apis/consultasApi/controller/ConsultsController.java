package com.apis.consultasApi.controller;

import java.net.ResponseCache;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyEmitter;

import com.apis.consultasApi.dtos.ConsultPatientsRequestDto;
import com.apis.consultasApi.dtos.ConsultRequestDTO;
import com.apis.consultasApi.dtos.ConsultResponseDTO;
import com.apis.consultasApi.dtos.ExamDTO;
import com.apis.consultasApi.service.ConsultService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/Consulta")
public class ConsultsController {

    @Autowired
    private ConsultService consultService;

    @GetMapping("/patient")
    @Tag(name = "Consultas", description = "Rota de consultas")
    @Operation(summary = "Seleção de paciente", description = "Rota responsável por selecionar paciente cadastrado, buscando por nome ou cpf")
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
    @Tag(name = "Consultas", description = "Rota de consultas")
    @Operation(summary = "Seleção de exames", description = "Rota responsável por selecionar o tipo de exame e retornar todos o exames cadastrados nele")
    public ResponseEntity<Object> getExam(@RequestBody ExamDTO examRequestDTO){
        try {
            var getExams = this.consultService.getExams(examRequestDTO);
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(getExams);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @PostMapping("/")
    @Tag(name = "Consultas", description = "Rota de consultas")
    @Operation(summary = "Marcar consulta", description = "Rota responsável por marcar uma consulta, utilizando o paciente, o tipo de exame, o exame escolhido e a data da consulta.")
    public ResponseEntity<Object> newConsult(@RequestBody ConsultRequestDTO consultRequestDTO){
        try {
            var consult = this.consultService.createConsult(consultRequestDTO);
            return ResponseEntity.status(HttpStatus.OK).body(consult);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
}
