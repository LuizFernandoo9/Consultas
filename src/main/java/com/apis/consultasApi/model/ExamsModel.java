package com.apis.consultasApi.model;

import java.util.UUID;

import io.swagger.v3.oas.annotations.media.Schema;
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

    @Schema(example = "Cirurgia cardíaca")
    private String name;
    
    @Schema(example = "Informar histórico de doenças, realizar exames de sangue, urina, eletrocardiograma e raio X")
    private String observation;

    @ManyToOne()
    @JoinColumn(name = "typeExamId",  nullable = false)
    private TypeExamsModel typeExamsModel;

}
