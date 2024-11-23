package com.apis.consultasApi.dtos;

import java.time.LocalDate;

import com.apis.consultasApi.enums.Gender;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ConsultPatientsDTO {

    private String name;
    private String cpf;
    private LocalDate dateOfBirth;
    private Gender gender;
    private String phone;
    private String email;
}
