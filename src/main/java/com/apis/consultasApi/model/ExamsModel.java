package com.apis.consultasApi.model;

import java.util.UUID;

import jakarta.persistence.Column;
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


@Entity(name = "Exams")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ExamsModel {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String name;
    private String observation;

    @ManyToOne()
    @JoinColumn(name = "typeExamId",  nullable = false)
    private TypeExamsModel typeExamsModel;

}
