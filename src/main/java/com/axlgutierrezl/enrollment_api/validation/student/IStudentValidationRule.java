package com.axlgutierrezl.enrollment_api.validation.student;

import com.axlgutierrezl.enrollment_api.dto.StudentDTO;

public interface IStudentValidationRule {
    void validate(StudentDTO studentDTO);
}
