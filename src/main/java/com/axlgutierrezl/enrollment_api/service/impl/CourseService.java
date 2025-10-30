package com.axlgutierrezl.enrollment_api.service.impl;

import com.axlgutierrezl.enrollment_api.dto.CourseDTO;
import com.axlgutierrezl.enrollment_api.mapper.CourseMapper;
import com.axlgutierrezl.enrollment_api.model.Course;
import com.axlgutierrezl.enrollment_api.repository.IGenericRepository;
import com.axlgutierrezl.enrollment_api.repository.ICourseRepository;
import com.axlgutierrezl.enrollment_api.service.ICourseService;
import com.axlgutierrezl.enrollment_api.validation.course.ICourseValidationRule;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseService extends CRUD<Course, CourseDTO, Integer> implements ICourseService {

    private final ICourseRepository iCourseRepository;
    private final CourseMapper studentMapper;
    private final List<ICourseValidationRule> validations;

    @Override
    protected IGenericRepository<Course, Integer> genericRepository() {
        return this.iCourseRepository;
    }

    @Override
    protected Course convertEntity(CourseDTO dto) {
        return this.studentMapper.convertEntity(dto);
    }

    @Override
    protected CourseDTO convertDTO(Course student) {
        return this.studentMapper.convertDto(student);
    }

    @Override
    protected void validation(CourseDTO studentDto) {
        validations.forEach(rule -> rule.validate(studentDto));
    }
}
