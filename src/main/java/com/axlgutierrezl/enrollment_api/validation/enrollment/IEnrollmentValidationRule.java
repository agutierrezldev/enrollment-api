package com.axlgutierrezl.enrollment_api.validation.enrollment;

import com.axlgutierrezl.enrollment_api.dto.EnrollmentDTO;

public interface IEnrollmentValidationRule {
    void validate(EnrollmentDTO enrollmentDTO);
}
