package com.apis.consultasApi.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apis.consultasApi.dtos.ConsultPatientsDTO;
import com.apis.consultasApi.dtos.ConsultPatientsRequestDto;
import com.apis.consultasApi.dtos.ExamRequestDTO;
import com.apis.consultasApi.dtos.TypeExamsDTO;
import com.apis.consultasApi.erros.ExamNotFoundException;
import com.apis.consultasApi.erros.PatientsNotFoundException;
import com.apis.consultasApi.erros.TypeExamsNotFoundException;
import com.apis.consultasApi.model.ConsultsModel;
import com.apis.consultasApi.model.TypeExamsModel;
import com.apis.consultasApi.repository.ConsultRepository;
import com.apis.consultasApi.repository.ExamsRepository;
import com.apis.consultasApi.repository.PatientsRepository;
import com.apis.consultasApi.repository.TypeExamsRepository;

@Service
public class ConsultService {

    @Autowired
    private PatientsRepository patientsRepository;

    @Autowired
    private ExamsRepository examsRepository;

    @Autowired TypeExamsRepository typeExamsRepository;

    @Autowired
    private ConsultRepository consultRepository;

    public ConsultPatientsDTO getPatients(ConsultPatientsRequestDto consultPatientsRequestDto){
        var patients = this.patientsRepository.findByNameOrCpf(consultPatientsRequestDto.getName(), consultPatientsRequestDto.getCpf()).orElseThrow(()->{
            throw new PatientsNotFoundException();
        });

       return ConsultPatientsDTO.builder()
       .name(patients.getName())
       .cpf(patients.getCpf())
       .dateOfBirth(patients.getDateOfBirth())
       .email(patients.getEmail())
       .gender(patients.getGender())
       .phone(patients.getPhone()).build();
    }

    public List<ExamRequestDTO> getExams(ExamRequestDTO examRequestDTO){

        var typeExamsId = this.typeExamsRepository.findById(examRequestDTO.getTypeExamId()).orElseThrow(()->{
            throw new TypeExamsNotFoundException();
        });
    
        return this.examsRepository.findByTypeExamsModel_Id(typeExamsId.getId()).stream().map(exam -> ExamRequestDTO.builder()
        .typeExamId(typeExamsId.getId())
        .name(exam.getName())
        .observation(exam.getObservation()).build()).collect(Collectors.toList());
    }


}
