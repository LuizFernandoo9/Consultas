package com.apis.consultasApi.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.apis.consultasApi.model.ExamsModel;

public interface ExamsRepository extends JpaRepository<ExamsModel, UUID>{
    
}