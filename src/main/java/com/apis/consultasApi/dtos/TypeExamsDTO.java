package com.apis.consultasApi.dtos;

import org.hibernate.validator.constraints.Length;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TypeExamsDTO {

    private String name;
    private String description;

}
