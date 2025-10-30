package com.axlgutierrezl.enrollment_api.dto;

import com.axlgutierrezl.enrollment_api.model.Status;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CourseDTO {
    private Integer id;

    @NotBlank(message = "El nombre es obligatorio")
    private String name;

    @NotBlank(message = "La Sigla es obligatorio")
    private String abbr;

    @NotNull(message = "El estado es obligatorio")
    private Status status;
}
