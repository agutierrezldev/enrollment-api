package com.axlgutierrezl.enrollment_api.repository;

import com.axlgutierrezl.enrollment_api.model.Enrollment;
import com.axlgutierrezl.enrollment_api.model.Student;

import java.time.LocalDateTime;
import java.util.Optional;

public interface IEnrollmentRepository extends IGenericRepository<Enrollment, Integer> {
    Optional<Enrollment> findByDateTimeAndStudent(LocalDateTime dateTime, Student student);
}
