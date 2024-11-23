package com.apis.consultasApi.service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apis.consultasApi.dtos.TypeExamsDTO;
import com.apis.consultasApi.erros.TypeExamsFoundException;
import com.apis.consultasApi.erros.TypeExamsNotFoundException;
import com.apis.consultasApi.model.TypeExamsModel;
import com.apis.consultasApi.repository.TypeExamsRepository;

@Service
public class TypeExamsService {

    @Autowired
    private TypeExamsRepository typeExamsRepository;

    public TypeExamsDTO create(TypeExamsModel typeExamsModel){
        this.typeExamsRepository.findByName(typeExamsModel.getName()).ifPresent(typeExam -> {
            throw new TypeExamsFoundException();
        }); 
        
        this.typeExamsRepository.save(typeExamsModel);

        return TypeExamsDTO.builder()
        .name(typeExamsModel.getName())
        .description(typeExamsModel.getDescription())
        .build();
        
    }

    public List<TypeExamsDTO> getTypeExams(TypeExamsModel typeExamsModel){
        
        if(typeExamsModel.getName().isEmpty()){
           return this.typeExamsRepository.findAll().stream().map(typeExams -> TypeExamsDTO.builder()
            .name(typeExams.getName())
            .description(typeExams.getDescription())
            .build()).collect(Collectors.toList());

        }else{
            var getTypeExams = this.typeExamsRepository.findByName(typeExamsModel.getName()).orElseThrow(()->{
                throw new TypeExamsNotFoundException();
            });
    
            return List.of(TypeExamsDTO.builder()
            .name(getTypeExams.getName())
            .description(getTypeExams.getDescription())
            .build());
        }
    }

    public TypeExamsDTO putTypeExmas(TypeExamsModel typeExamsModel, UUID id){

        var typeExam = this.typeExamsRepository.findById(id).orElseThrow(()->{
            throw new TypeExamsNotFoundException();
        });

        typeExam.setName(typeExamsModel.getName());
        typeExam.setDescription(typeExamsModel.getDescription());

        this.typeExamsRepository.save(typeExam);

        return TypeExamsDTO.builder()
        .name(typeExam.getName())
        .description(typeExam.getDescription()).build();

    }


    public void deleteTypeExams(UUID id){

        this.typeExamsRepository.findById(id).orElseThrow(()->{
            throw new TypeExamsNotFoundException();
        });

        this.typeExamsRepository.deleteById(id);
    }
}
