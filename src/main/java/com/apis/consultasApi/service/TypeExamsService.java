package com.apis.consultasApi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apis.consultasApi.erros.TypeExamsFoundException;
import com.apis.consultasApi.model.TypeExamsModel;
import com.apis.consultasApi.repository.TypeExamsRepository;

@Service
public class TypeExamsService {

    @Autowired
    private TypeExamsRepository typeExamsRepository;

    public TypeExamsModel create(TypeExamsModel typeExamsModel){
        this.typeExamsRepository.findByNameTypeExam(typeExamsModel.getNameTypeExam()).ifPresent(typeExam -> {
            throw new TypeExamsFoundException();
        }); 
        
        return this.typeExamsRepository.save(typeExamsModel);
        
    }
}
