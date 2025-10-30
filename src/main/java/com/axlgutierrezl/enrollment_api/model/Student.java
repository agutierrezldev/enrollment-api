package com.axlgutierrezl.enrollment_api.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Student {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer id;

    @Column(length = 150, nullable = false)
    @NotBlank(message = "El nombre es obligatorio")
    private String firstName;

    @Column(length = 150, nullable = false)
    @NotBlank(message = "El apellido es obligatorio")
    private String lastName;

    @Column(length = 8, nullable = false, unique = true)
    @NotBlank(message = "El DNI es obligatorio")
    @Size(min = 8, max = 8, message = "El DNI debe tener 8 dígitos")
    private String dni;

    @Column(nullable = false)
    private Integer age;
}
