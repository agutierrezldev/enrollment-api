package com.axlgutierrezl.enrollment_api.service;

import com.axlgutierrezl.enrollment_api.dto.EnrollmentDTO;
import com.axlgutierrezl.enrollment_api.model.Enrollment;

import java.util.List;
import java.util.Map;

public interface IEnrollmentService extends ICRUD<Enrollment, EnrollmentDTO, Integer> {

    Map<String, List<String>> getStudentsByCourse();
}
