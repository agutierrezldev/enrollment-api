package com.axlgutierrezl.enrollment_api.mapper;

import com.axlgutierrezl.enrollment_api.dto.CourseDTO;
import com.axlgutierrezl.enrollment_api.model.Course;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CourseMapper {

    private final ModelMapper modelMapper;

    public Course convertEntity(CourseDTO courseDTO) {
        return this.modelMapper.map(courseDTO, Course.class);
    }

    public CourseDTO convertDto(Course student) {
        return this.modelMapper.map(student, CourseDTO.class);
    }

}
