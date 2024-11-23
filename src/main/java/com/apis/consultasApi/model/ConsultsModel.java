package com.apis.consultasApi.model;

import java.time.LocalDateTime;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "Consults")
public class ConsultsModel {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID protocol;

    @ManyToOne()
    @JoinColumn(name = "patientsId", nullable = false)
    private PatientsModel patientsModel;

    @ManyToOne()
    @JoinColumn(name = "examsId", nullable = false)
    private ExamsModel examsModel;

    @ManyToOne()
    @JoinColumn(name = "typeExamsId", nullable = false)
    private TypeExamsModel typeExamsModel;

    @CreationTimestamp
    private LocalDateTime createdAt;

    private LocalDateTime newConsultAt;
}
