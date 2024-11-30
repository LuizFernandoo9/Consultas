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

import com.apis.consultasApi.dtos.ExamDTO;
import com.apis.consultasApi.model.ExamsModel;
import com.apis.consultasApi.service.ExamsService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.var;

@RestController
@RequestMapping("/Exame")
public class ExamsController {

    @Autowired
    private ExamsService examsService;

    @PostMapping("/")
    @Tag(name = "Exames", description = "Rota de Exames")
    @Operation(summary = "Cria novos exames", description = "Endpoint responsável por criar novos exames")
    public ResponseEntity<Object> newExam(@Valid @RequestBody ExamDTO examRequestDTO){
        try {
            var exam = this.examsService.createExam(examRequestDTO);
            return ResponseEntity.status(HttpStatus.OK).body(exam);
        } catch (Exception e) {
            //e.printStackTrace();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @GetMapping("/")
    @Tag(name = "Exames", description = "Rota de Exames")
    @Operation(summary = "Lista os exames", description = "Endpoint responsável por listar os exames cadastrados. Caso utilize o nome para buscar, se cadastrado, irá retornar apenas o exame")
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
    @Tag(name = "Exames", description = "Rota de Exames")
    @Operation(summary = "Editar exames", description = "Endpoint responsável por atualizar os dados do exame, como nome e observações, com base no id")
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
    @Tag(name = "Exames", description = "Rota de Exames")
    @Operation(summary = "Deletar exames", description = "Endpoint responsável por deletar o exame, com base no id")
    public ResponseEntity<Object> deleteExam(@PathVariable UUID id){
        try {
            this.examsService.deleteExam(id);
            return ResponseEntity.status(HttpStatus.ACCEPTED).body("Exame deletado");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
}
