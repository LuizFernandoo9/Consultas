package com.apis.consultasApi.controller;

import java.util.UUID;

import org.antlr.v4.runtime.misc.ObjectEqualityComparator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.apis.consultasApi.model.PatientsModel;
import com.apis.consultasApi.service.PatientsService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/Pacientes")
public class PatientsController {

    @Autowired
    private PatientsService patientsService;

    @PostMapping("/")
    public ResponseEntity<Object> createPatients(@Valid @RequestBody PatientsModel patientsModel){
        try{
            var patients = this.patientsService.create(patientsModel);
            return ResponseEntity.status(HttpStatus.OK).body(patients);
        }catch(Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @GetMapping("/")
    public ResponseEntity<Object> getPatients(@Valid @RequestBody PatientsModel patientsModel){
        try{
            var listPatients = this.patientsService.getPatient(patientsModel);
            return ResponseEntity.status(HttpStatus.OK).body(listPatients);
        }catch(Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deletePatients(@PathVariable UUID id){
        try{
            this.patientsService.deletePatient(id);
            return ResponseEntity.status(HttpStatus.OK).body("Paciente apagado!");
        }catch(Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }




}
