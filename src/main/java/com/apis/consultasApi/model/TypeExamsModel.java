package com.apis.consultasApi.model;

import java.util.UUID;

import org.hibernate.validator.constraints.Length;

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
    private String name;

    private String description;

}
