package com.axlgutierrezl.enrollment_api.validation.enrollment.impl;

import com.axlgutierrezl.enrollment_api.dto.EnrollmentDTO;
import com.axlgutierrezl.enrollment_api.exception.BusinessValidationException;
import com.axlgutierrezl.enrollment_api.mapper.StudentMapper;
import com.axlgutierrezl.enrollment_api.repository.IEnrollmentRepository;
import com.axlgutierrezl.enrollment_api.validation.enrollment.IEnrollmentValidationRule;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class EnrollmentUniqueDateTimeAndStudentRule implements IEnrollmentValidationRule {

    private final IEnrollmentRepository enrollmentRepository;
    private final StudentMapper studentMapper;

    @Override
    public void validate(EnrollmentDTO enrollmentDTO) {
        log.info("EnrollmentValidation - starting rule EnrollmentUniqueDateTimeAndStudentRule operation with data: {}", enrollmentDTO);
        this.enrollmentRepository.findByDateTimeAndStudent(enrollmentDTO.getDateTime(), this.studentMapper.convertEntity(enrollmentDTO.getStudent()))
                .ifPresent(enrollment -> {
                    if (!enrollment.getId().equals(enrollmentDTO.getId())) {
                        throw new BusinessValidationException("Enrollment with DateTime " + enrollmentDTO.getDateTime() +
                                " and Student with ID " + enrollmentDTO.getStudent().getId() + " exits.");
                    }
                });
    }
}
