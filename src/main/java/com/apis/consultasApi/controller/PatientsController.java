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
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/Pacientes")
public class PatientsController {

    @Autowired
    private PatientsService patientsService;

    @PostMapping("/")
    @Tag(name = "Pacientes", description = "Rota de pacientes")
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
    @Tag(name = "Pacientes", description = "Rota de pacientes")
    @Operation(summary = "Listar os pacientes", description = "Endpoint responsável por listar os pacientes cadastrados. Caso utilize o nome para buscar o paciente, se cadastrado, irá retornar apenas o paciente")
    public ResponseEntity<Object> getPatients(@Valid @RequestBody PatientsModel patientsModel){
        try{
            var listPatients = this.patientsService.getPatient(patientsModel);
            return ResponseEntity.status(HttpStatus.OK).body(listPatients);
        }catch(Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @PutMapping("/{id}")
    @Tag(name = "Pacientes", description = "Rota de pacientes")
    @Operation(summary = "Atualizar dados do paciente", description = "Endpoint realiza atualização de dados, como telefone e email, com base no id")
    public ResponseEntity<Object> putPatients(@Valid @RequestBody PatientsModel patientsModel, @PathVariable UUID id){
        try {
            var patientsEdited = this.patientsService.editPatient(patientsModel, id);
            return ResponseEntity.status(HttpStatus.OK).body(patientsEdited);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    @Tag(name = "Pacientes", description = "Rota de pacientes")
    @Operation(summary = "Deleta os pacientes", description = "Endpoint responável por deletar os pacientes cadastrados, com base no id")
    public ResponseEntity<Object> deletePatients(@PathVariable UUID id){

        try{
            this.patientsService.deletePatient(id);
            return ResponseEntity.status(HttpStatus.OK).body("Paciente apagado!");
        }catch(Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }    
}
