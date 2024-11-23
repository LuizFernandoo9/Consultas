package com.apis.consultasApi.dtos;

import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ExamRequestDTO {

    private String name;
    private String observation;
    private UUID typeExamId;
}
