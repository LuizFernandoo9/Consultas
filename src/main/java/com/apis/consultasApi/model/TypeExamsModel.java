package com.apis.consultasApi.model;

import java.util.UUID;

import org.hibernate.validator.constraints.Length;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "TypeExams")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TypeExamsModel {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Length(max = 100)
    @Schema(example = "Cirurgia")
    private String name;

    @Schema(example = "Realização de cirurgias")
    private String description;

}
