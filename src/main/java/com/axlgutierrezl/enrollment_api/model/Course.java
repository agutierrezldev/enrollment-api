package com.axlgutierrezl.enrollment_api.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Course {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer id;

    @Column(length = 150, nullable = false)
    @NotBlank(message = "El nombre es obligatorio")
    private String name;

    @Column(length = 150, nullable = false)
    @NotBlank(message = "La sigla es obligatorio")
    private String abbr;

    @Column(nullable = false)
    private Status status;
}
