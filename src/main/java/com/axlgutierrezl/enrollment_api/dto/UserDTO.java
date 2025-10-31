package com.axlgutierrezl.enrollment_api.dto;

import com.axlgutierrezl.enrollment_api.model.Status;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonIncludeProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserDTO {
    private Integer id;

    @NotNull
    @JsonIncludeProperties(value = {"id"})
    private RoleDTO role;

    @NotNull
    private String username;

    @NotNull
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;

    @NotNull(message = "El estado es obligatorio")
    private Status status;
}
