package com.apis.consultasApi.repository;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.apis.consultasApi.model.ConsultsModel;

public interface ConsultRepository extends JpaRepository<ConsultsModel, UUID>{

    Optional<ConsultsModel> findByNewConsultAt(LocalDateTime newConsultAt);
}
