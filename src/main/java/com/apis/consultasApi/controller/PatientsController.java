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

import com.apis.consultasApi.model.PatientsModel;
import com.apis.consultasApi.service.PatientsService;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/Pacientes")
public class PatientsController {

    @Autowired
    private PatientsService patientsService;

    @PostMapping("/")
    @Operation(summary = "Cadastra pacientes", description = "Rota responsável por cadastrar novos pacientes")
    public ResponseEntity<Object> createPatients(@Valid @RequestBody PatientsModel patientsModel){

        try{
            var patients = this.patientsService.create(patientsModel);
            return ResponseEntity.status(HttpStatus.OK).body(patients);
        }catch(Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @GetMapping("/")
    @Operation(summary = "Acessa os pacientes", description = "Rota responsável por listar, mostrar os pacientes cadastrados")
    public ResponseEntity<Object> getPatients(@Valid @RequestBody PatientsModel patientsModel){
        try{
            var listPatients = this.patientsService.getPatient(patientsModel);
            return ResponseEntity.status(HttpStatus.OK).body(listPatients);
        }catch(Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualiza dados", description = "Rota realiza atualização de dados como telefone e email")
    public ResponseEntity<Object> putPatients(@Valid @RequestBody PatientsModel patientsModel, @PathVariable UUID id){
        try {
            var patientsEdited = this.patientsService.editPatient(patientsModel, id);
            return ResponseEntity.status(HttpStatus.OK).body(patientsEdited);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Deleta os pacientes", description = "Rota para deletar os pacientes")
    public ResponseEntity<Object> deletePatients(@PathVariable UUID id){

        try{
            this.patientsService.deletePatient(id);
            return ResponseEntity.status(HttpStatus.OK).body("Paciente apagado!");
        }catch(Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }    
}
