package com.axlgutierrezl.enrollment_api.mapper;

import com.axlgutierrezl.enrollment_api.dto.EnrollmentDTO;
import com.axlgutierrezl.enrollment_api.model.Enrollment;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class EnrollmentMapper {

    private final ModelMapper modelMapper;

    public Enrollment convertEntity(EnrollmentDTO enrollmentDTO) {
        return this.modelMapper.map(enrollmentDTO, Enrollment.class);
    }

    public EnrollmentDTO convertDto(Enrollment enrollment) {
        return this.modelMapper.map(enrollment, EnrollmentDTO.class);
    }

}
