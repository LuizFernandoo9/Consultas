package com.apis.consultasApi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
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
    public ResponseEntity<Object> postTypeExam(@Valid @RequestBody TypeExamsModel typeExamsModel){
        try {
            var newTypeExam = this.typeExamsService.create(typeExamsModel);
            return ResponseEntity.status(HttpStatus.OK).body(newTypeExam);
        } catch (Exception e) {
           return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }

    }
}
