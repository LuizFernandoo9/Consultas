package com.apis.consultasApi.repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.apis.consultasApi.dtos.ExamDTO;
import com.apis.consultasApi.model.ExamsModel;

public interface ExamsRepository extends JpaRepository<ExamsModel, UUID>{
    
    Optional<ExamsModel> findByNameAndObservation(String name, String observation);

    Optional<ExamsModel> findByName(String name);

    Optional<ExamsModel> findByNameOrObservation(String name, String observation);

    Optional<ExamsModel> findByTypeExamsModel_Id(UUID typeExamId);

}