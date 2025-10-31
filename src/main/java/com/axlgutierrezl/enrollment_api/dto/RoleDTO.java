package com.axlgutierrezl.enrollment_api.dto;

import com.axlgutierrezl.enrollment_api.model.Status;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RoleDTO {
    private Integer id;

    @NotNull
    @Size(min = 3, max = 50)
    private String name;

    @NotNull(message = "El estado es obligatorio")
    private Status status;
}
