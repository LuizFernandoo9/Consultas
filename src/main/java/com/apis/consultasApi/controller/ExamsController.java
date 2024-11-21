package com.apis.consultasApi.controller;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.service.annotation.PutExchange;

import com.apis.consultasApi.dtos.ExamRequestDTO;
import com.apis.consultasApi.model.ExamsModel;
import com.apis.consultasApi.service.ExamsService;


import jakarta.validation.Valid;
import lombok.var;

@RestController
@RequestMapping("/Exame")
public class ExamsController {

    @Autowired
    private ExamsService examsService;

    @PostMapping("/")
    public ResponseEntity<Object> newExam(@Valid @RequestBody ExamRequestDTO examRequestDTO){
        try {
            var exam = this.examsService.createExam(examRequestDTO);
            return ResponseEntity.status(HttpStatus.OK).body(exam);
        } catch (Exception e) {
            //e.printStackTrace();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @GetMapping("/")
    public ResponseEntity<Object> getExam(@Valid @RequestBody ExamsModel examsModel){
        try {
            var exam = this.examsService.getExam(examsModel);
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(exam);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> putExam(@Valid @RequestBody ExamsModel examsModel, @PathVariable UUID id){
        try {
            var exam = this.examsService.editExam(examsModel, id);
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(exam);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteExam(UUID id){
        try {
            this.examsService.deleteExam(id);
            return ResponseEntity.status(HttpStatus.ACCEPTED).body("Exame deletado");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
}
