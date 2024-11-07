package com.apis.consultasApi.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.apis.consultasApi.model.TypeExamsModel;

public interface TypeExamsRepository extends JpaRepository<TypeExamsModel, UUID>{

}
