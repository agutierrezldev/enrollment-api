package com.axlgutierrezl.enrollment_api.validation.course;

import com.axlgutierrezl.enrollment_api.dto.CourseDTO;

public interface ICourseValidationRule {
    void validate(CourseDTO courseDTO);
}
