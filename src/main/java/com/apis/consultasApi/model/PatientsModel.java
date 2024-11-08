package com.apis.consultasApi.model;

import java.time.LocalDate;
import java.util.UUID;

import org.hibernate.validator.constraints.Length;

import com.apis.consultasApi.enums.Gender;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "Patients")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PatientsModel {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Length(max = 100)
    private String name;

    @Pattern(regexp = "\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}", message = "o cpf deve estar no formato 000.000.000-00")
    private String cpf;

    private LocalDate dateOfBirth;

    private Gender gender;

    @Pattern(regexp = "\\(\\d{2}\\)\\d{5}-\\d{4}", message = "telefone deve estar no formato (xx)xxxxx-xxxx")
    private String phone;

    @Email(message = "Deve conter um email válido")
    private String email;

}
