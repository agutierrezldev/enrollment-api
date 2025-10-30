package com.axlgutierrezl.enrollment_api.dto;

import com.axlgutierrezl.enrollment_api.model.Status;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@ToString(exclude = "details")
public class EnrollmentDTO {
    private Integer id;

    @NotNull
    private LocalDateTime dateTime;

    @NotNull
    private StudentDTO student;

    @NotNull
    private Status status;

    @NotNull
    @JsonManagedReference
    private List<EnrollmentDetailDTO> details;
}
