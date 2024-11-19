package com.apis.consultasApi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apis.consultasApi.dtos.ExamRequestDTO;
import com.apis.consultasApi.erros.ExamsFoundException;
import com.apis.consultasApi.erros.TypeExamsNotFoundException;
import com.apis.consultasApi.model.ExamsModel;
import com.apis.consultasApi.model.TypeExamsModel;
import com.apis.consultasApi.repository.ExamsRepository;
import com.apis.consultasApi.repository.TypeExamsRepository;

@Service
public class ExamsService {

    @Autowired
    private ExamsRepository examsRepository;

    @Autowired
    private TypeExamsRepository typeExamsRepository;

    public ExamRequestDTO createExam(ExamRequestDTO examRequestDTO){
        System.out.println("o Id será pego a seguir" + examRequestDTO.getTypeExamId());
        var typeExamId = this.typeExamsRepository.findById(examRequestDTO.getTypeExamId()).orElseThrow(()->{
            throw new TypeExamsNotFoundException();
        });
        System.out.println("Id: "+ typeExamId);

        this.examsRepository.findByNameAndObservation(examRequestDTO.getName(), examRequestDTO.getObservation()).ifPresent(exam -> {
            throw new ExamsFoundException();
        });

       var examModel = ExamsModel.builder()
       .name(examRequestDTO.getName())
       .observation(examRequestDTO.getObservation())
       .typeExamsModel(typeExamId)
       .build();

        this.examsRepository.save(examModel);

        return ExamRequestDTO.builder()
        .name(examModel.getName())
        .observation(examModel.getObservation())
        .typeExamId(examModel.getTypeExamsModel().getId()).build();
    }
}
