package com.axlgutierrezl.enrollment_api.service.impl;

import com.axlgutierrezl.enrollment_api.dto.StudentDTO;
import com.axlgutierrezl.enrollment_api.mapper.StudentMapper;
import com.axlgutierrezl.enrollment_api.model.Student;
import com.axlgutierrezl.enrollment_api.repository.IGenericRepository;
import com.axlgutierrezl.enrollment_api.repository.IStudentRepository;
import com.axlgutierrezl.enrollment_api.service.IStudentService;
import com.axlgutierrezl.enrollment_api.validation.student.IStudentValidationRule;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

@Service
@RequiredArgsConstructor
public class StudentService extends CRUD<Student, StudentDTO, Integer> implements IStudentService {

    private final IStudentRepository iStudentRepository;
    private final StudentMapper studentMapper;
    private final List<IStudentValidationRule> validations;

    @Override
    protected IGenericRepository<Student, Integer> genericRepository() {
        return this.iStudentRepository;
    }

    @Override
    protected Student convertEntity(StudentDTO dto) {
        return this.studentMapper.convertEntity(dto);
    }

    @Override
    protected StudentDTO convertDTO(Student student) {
        return this.studentMapper.convertDto(student);
    }

    @Override
    protected void validation(StudentDTO studentDto) {
        validations.forEach(rule -> rule.validate(studentDto));
    }

    @Override
    public Page<StudentDTO> getAllPaginationByAgeSort(String sort, Pageable pageable) throws Exception {
        Page<Student> students = this.iStudentRepository.findAll(pageable);
        Stream<Student> sortedStream = switch (sort.toUpperCase()) {
            // case "ASC" -> students.stream().sorted((s1, s2) -> Integer.compare(s1.getAge(), s2.getAge()));
            case "ASC" -> students.stream().sorted(Comparator.comparingInt(Student::getAge));
            case "DESC" -> students.stream().sorted((s1, s2) -> Integer.compare(s2.getAge(), s1.getAge()));
            default -> throw new IllegalArgumentException(
                    "Invalid sort value: " + sort + ". Allowed values are 'ASC' or 'DESC'.");
        };

        List<StudentDTO> sortedList = sortedStream.map(this::convertDTO).toList();
        return new PageImpl<>(sortedList, pageable, students.getTotalElements());
    }


}
