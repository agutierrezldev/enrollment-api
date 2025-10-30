package com.axlgutierrezl.enrollment_api.validation.course.impl;

import com.axlgutierrezl.enrollment_api.dto.CourseDTO;
import com.axlgutierrezl.enrollment_api.exception.BusinessValidationException;
import com.axlgutierrezl.enrollment_api.repository.ICourseRepository;
import com.axlgutierrezl.enrollment_api.validation.course.ICourseValidationRule;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class CourseUniqueNameAndAbbrRule implements ICourseValidationRule {

    private final ICourseRepository courseRepository;

    @Override
    public void validate(CourseDTO courseDTO) {
        log.info("CourseValidation - starting rule CourseUniqueNameAndAbbrRule operation with data: {}", courseDTO);
        this.courseRepository.findByNameAndAbbr(courseDTO.getName(), courseDTO.getAbbr())
                .ifPresent(course -> {
                    if (!course.getId().equals(courseDTO.getId())) {
                        throw new BusinessValidationException("Course with Name " + courseDTO.getName() +
                                " and Abbreviation " + courseDTO.getAbbr() + " exits.");
                    }
                });
    }
}
