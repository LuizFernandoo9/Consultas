package com.apis.consultasApi.service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apis.consultasApi.dtos.ExamDTO;
import com.apis.consultasApi.erros.ExamNotFoundException;
import com.apis.consultasApi.erros.ExamsFoundException;
import com.apis.consultasApi.erros.TypeExamsNotFoundException;
import com.apis.consultasApi.model.ExamsModel;
import com.apis.consultasApi.repository.ExamsRepository;
import com.apis.consultasApi.repository.TypeExamsRepository;

@Service
public class ExamsService {

    @Autowired
    private ExamsRepository examsRepository;

    @Autowired
    private TypeExamsRepository typeExamsRepository;

    public ExamDTO createExam(ExamDTO examRequestDTO){
        
        var typeExamId = this.typeExamsRepository.findById(examRequestDTO.getTypeExamId()).orElseThrow(()->{
            throw new TypeExamsNotFoundException();
        });

        this.examsRepository.findByNameAndObservation(examRequestDTO.getName(), examRequestDTO.getObservation()).ifPresent(exam -> {
            throw new ExamsFoundException();
        });

       var examModel = ExamsModel.builder()
       .name(examRequestDTO.getName())
       .observation(examRequestDTO.getObservation())
       .typeExamsModel(typeExamId)
       .build();

        this.examsRepository.save(examModel);

        return ExamDTO.builder()
        .name(examModel.getName())
        .observation(examModel.getObservation())
        .typeExamId(examModel.getTypeExamsModel().getId()).build();
    }

    public List<ExamDTO> getExam(ExamsModel examsModel){

        if(examsModel.getName().isEmpty()){
            return this.examsRepository.findAll().stream().map(exam -> ExamDTO.builder()
            .name(exam.getName())
            .observation(exam.getObservation())
            .typeExamId(exam.getTypeExamsModel().getId()).build()).collect(Collectors.toList());

        }else{
            var exams = this.examsRepository.findByName(examsModel.getName()).orElseThrow(()->{
                throw new ExamNotFoundException();
            });

            return List.of(ExamDTO.builder()
            .name(exams.getName())
            .observation(exams.getObservation())
            .typeExamId(exams.getTypeExamsModel().getId()).build());
        }
    }

    public ExamDTO editExam(ExamsModel examsModel, UUID id){

        var idExam = this.examsRepository.findById(id).orElseThrow(()->{
            throw new ExamNotFoundException();
        });

        idExam.setName(examsModel.getName());
        idExam.setObservation(examsModel.getObservation());

        this.examsRepository.save(idExam);

        return ExamDTO.builder()
        .name(idExam.getName())
        .observation(idExam.getObservation())
        .typeExamId(idExam.getTypeExamsModel().getId())
        .build();
    }

    public void deleteExam( UUID id){
        var exam = this.examsRepository.findById(id).orElseThrow(()->{
            throw new ExamNotFoundException();
        });

        this.examsRepository.delete(exam);
    }
}
