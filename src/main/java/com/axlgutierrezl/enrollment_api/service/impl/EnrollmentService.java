package com.axlgutierrezl.enrollment_api.service.impl;

import com.axlgutierrezl.enrollment_api.dto.EnrollmentDTO;
import com.axlgutierrezl.enrollment_api.mapper.EnrollmentMapper;
import com.axlgutierrezl.enrollment_api.model.Enrollment;
import com.axlgutierrezl.enrollment_api.model.EnrollmentDetail;
import com.axlgutierrezl.enrollment_api.repository.IEnrollmentRepository;
import com.axlgutierrezl.enrollment_api.repository.IGenericRepository;
import com.axlgutierrezl.enrollment_api.service.IEnrollmentService;
import com.axlgutierrezl.enrollment_api.validation.enrollment.IEnrollmentValidationRule;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
@RequiredArgsConstructor
public class EnrollmentService extends CRUD<Enrollment, EnrollmentDTO, Integer> implements IEnrollmentService {

    private final IEnrollmentRepository iEnrollmentRepository;
    private final EnrollmentMapper enrollmentMapper;
    private final List<IEnrollmentValidationRule> validations;

    @Override
    protected IGenericRepository<Enrollment, Integer> genericRepository() {
        return this.iEnrollmentRepository;
    }

    @Override
    protected Enrollment convertEntity(EnrollmentDTO dto) {
        return this.enrollmentMapper.convertEntity(dto);
    }

    @Override
    protected EnrollmentDTO convertDTO(Enrollment enrollment) {
        return this.enrollmentMapper.convertDto(enrollment);
    }

    @Override
    protected void validation(EnrollmentDTO enrollmentDto) {
        validations.forEach(rule -> rule.validate(enrollmentDto));
    }

    @Override
    public Map<String, List<String>> getStudentsByCourse() {
        Stream<Enrollment> enrollmentStream = this.iEnrollmentRepository.findAll().stream();
        Stream<List<EnrollmentDetail>> listDetailsEnrollmentStream = enrollmentStream.map(Enrollment::getDetails); // enrollment -> enrollment.getDetails()
        Stream<EnrollmentDetail> detailsEnrollmentStream = listDetailsEnrollmentStream.flatMap(Collection::stream); // list -> list.stream()

        return detailsEnrollmentStream
                .map(detail -> Map.entry(
                        detail.getCourse().getName(),
                        detail.getEnrollment().getStudent().getFirstName().concat(" ").concat(detail.getEnrollment().getStudent().getLastName())))
                .collect(Collectors.groupingBy(
                        Map.Entry::getKey,
                        Collectors.mapping(Map.Entry::getValue, Collectors.toList())
                ));
    }
}
