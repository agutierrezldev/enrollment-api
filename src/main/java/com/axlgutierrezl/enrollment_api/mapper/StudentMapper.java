package com.axlgutierrezl.enrollment_api.mapper;

import com.axlgutierrezl.enrollment_api.dto.StudentDTO;
import com.axlgutierrezl.enrollment_api.model.Student;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class StudentMapper {

    private final ModelMapper modelMapper;

    public Student convertEntity(StudentDTO studentDTO) {
        return this.modelMapper.map(studentDTO, Student.class);
    }

    public StudentDTO convertDto(Student student) {
        return this.modelMapper.map(student, StudentDTO.class);
    }

}
