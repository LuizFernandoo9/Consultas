package com.apis.consultasApi.dtos;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ConsultRequestDTO {

    
    private String patientName;
    private String patientCPF;
    private String examName;
    private String typeExamName;
    private LocalDateTime NewConsultAt;
}
