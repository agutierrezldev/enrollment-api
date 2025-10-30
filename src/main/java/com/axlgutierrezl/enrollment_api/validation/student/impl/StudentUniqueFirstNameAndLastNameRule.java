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
public class StudentUniqueFirstNameAndLastNameRule implements IStudentValidationRule {

    private final IStudentRepository studentRepository;

    @Override
    public void validate(StudentDTO studentDTO) {
        log.info("StudentValidation - starting rule StudentUniqueFirstNameAndLastNameRule operation with data: {}", studentDTO);
        this.studentRepository.findByFirstNameAndLastName(studentDTO.getFirstName(), studentDTO.getLastName())
                .ifPresent(student -> {
                    if (!student.getId().equals(studentDTO.getId())) {
                        throw new BusinessValidationException("Student with First Name " + studentDTO.getFirstName() +
                                " and Last Name " + studentDTO.getLastName() + " exits.");
                    }
                });
    }
}
