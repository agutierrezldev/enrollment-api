package com.axlgutierrezl.enrollment_api.validation.student.impl;

import com.axlgutierrezl.enrollment_api.dto.StudentDTO;
import com.axlgutierrezl.enrollment_api.exception.BusinessValidationException;
import com.axlgutierrezl.enrollment_api.repository.IStudentRepository;
import com.axlgutierrezl.enrollment_api.validation.student.IStudentValidationRule;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class StudentUniqueDNIRule implements IStudentValidationRule {

    private final IStudentRepository studentRepository;

    @Override
    public void validate(StudentDTO studentDTO) {
        log.info("StudentValidation - starting rule StudentUniqueDNIRule operation with data: {}", studentDTO);
        this.studentRepository.findByDni(studentDTO.getDni())
                .ifPresent(student -> {
                    if (!student.getId().equals(studentDTO.getId())) {
                        throw new BusinessValidationException("Student with DNI " + studentDTO.getDni() + " exits.");
                    }
                });
    }
}
