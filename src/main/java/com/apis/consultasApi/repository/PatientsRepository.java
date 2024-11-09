package com.apis.consultasApi.repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.apis.consultasApi.model.PatientsModel;

public interface PatientsRepository extends JpaRepository<PatientsModel, UUID>{

    Optional<PatientsModel> findByNameOrCpf(String name, String category);

    Optional<PatientsModel> findByNameAndCpf(String name, String category);

    Optional<PatientsModel> findByEmailAndPhone(String email, String phone);
}
