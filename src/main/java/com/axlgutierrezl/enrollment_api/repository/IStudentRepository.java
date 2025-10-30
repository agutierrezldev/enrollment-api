package com.axlgutierrezl.enrollment_api.repository;

import com.axlgutierrezl.enrollment_api.model.Student;

import java.util.Optional;

public interface IStudentRepository extends IGenericRepository<Student, Integer> {

    Optional<Student> findByFirstNameAndLastName(String firstName, String lastName);
    Optional<Student> findByDni(String dni);
}
