package com.apis.consultasApi.service;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apis.consultasApi.erros.PatientsFoundException;
import com.apis.consultasApi.erros.PatientsNotFoundException;
import com.apis.consultasApi.model.PatientsModel;
import com.apis.consultasApi.repository.PatientsRepository;

@Service
public class PatientsService {

    @Autowired
    private PatientsRepository patientsRepository;

    public PatientsModel create(PatientsModel patientsModel){

        this.patientsRepository.findByNameOrCpf(patientsModel.getName(), patientsModel.getCpf()).ifPresent(patient ->{
            throw new PatientsFoundException();
        });

       var patient =  this.patientsRepository.save(patientsModel);
    
       return patient;
    }

    public List<PatientsModel> getPatient(PatientsModel patientsModel){

        if(patientsModel.getName().isEmpty() && patientsModel.getCpf().isEmpty()){
            return this.patientsRepository.findAll().stream().map(patients -> PatientsModel.builder()
            .name(patients.getName())
            .cpf(patients.getCpf())
            .email(patients.getEmail())
            .gender(patients.getGender())
            .phone(patients.getPhone())
            .dateOfBirth(patients.getDateOfBirth()).build()).collect(Collectors.toList());
        }else{

            var patient = this.patientsRepository.findByNameAndCpf(patientsModel.getName(), patientsModel.getCpf()).orElseThrow(()->{
                throw new PatientsNotFoundException();
            });

            return List.of(PatientsModel.builder()
            .name(patient.getName())
            .cpf(patient.getCpf())
            .email(patient.getEmail())
            .gender(patient.getGender())
            .phone(patient.getPhone())
            .dateOfBirth(patient.getDateOfBirth()).build());
        }

    }

}
