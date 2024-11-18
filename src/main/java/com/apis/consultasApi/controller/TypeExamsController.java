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

import com.apis.consultasApi.model.TypeExamsModel;
import com.apis.consultasApi.service.TypeExamsService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/TiposDeExame")
public class TypeExamsController {

    @Autowired
    private TypeExamsService typeExamsService;

    @PostMapping("/")
    public ResponseEntity<Object> newTypeExam(@Valid @RequestBody TypeExamsModel typeExamsModel){
        try {
            var newTypeExam = this.typeExamsService.create(typeExamsModel);
            return ResponseEntity.status(HttpStatus.OK).body(newTypeExam);
        } catch (Exception e) {
           return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @GetMapping("/")
    public ResponseEntity<Object> getTypeExam(@Valid @RequestBody TypeExamsModel typeExamsModel){
        try {
            var get = this.typeExamsService.getTypeExams(typeExamsModel);
            return ResponseEntity.status(HttpStatus.OK).body(get);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> editTypeExam(@Valid @RequestBody TypeExamsModel typeExamsModel, @PathVariable UUID id){
        try {
            var edit = this.typeExamsService.putTypeExmas(typeExamsModel, id);
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(edit);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteTypeExam(@PathVariable UUID id){
        try {
            this.typeExamsService.deleteTypeExams(id);
            return ResponseEntity.status(HttpStatus.OK).body("Tipo de exame deletado com sucesso");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
}
