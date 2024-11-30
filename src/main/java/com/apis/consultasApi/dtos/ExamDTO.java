package com.apis.consultasApi.dtos;

import java.util.UUID;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ExamDTO {

    @Schema(example = "Cirurgia cardíaca")
    private String name;
    @Schema(example = "Informar histórico de doenças, realizar exames de sangue, urina, eletrocardiograma e raio X")
    private String observation;
    private UUID typeExamId;
}
