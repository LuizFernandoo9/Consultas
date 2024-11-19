package com.apis.consultasApi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.apis.consultasApi.dtos.ExamRequestDTO;
import com.apis.consultasApi.model.ExamsModel;
import com.apis.consultasApi.service.ExamsService;


import jakarta.validation.Valid;

@RestController
@RequestMapping("/Exame")
public class ExamsController {

    @Autowired
    private ExamsService examsService;

    @PostMapping("/")
    public ResponseEntity<Object> newExam(@RequestBody  ExamRequestDTO examRequestDTO){
        try {
            System.out.println("DTO recebido: " + examRequestDTO);
            var exam = this.examsService.createExam(examRequestDTO);
            return ResponseEntity.status(HttpStatus.OK).body(exam);
        } catch (Exception e) {
            //e.printStackTrace();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
}
