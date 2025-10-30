package com.axlgutierrezl.enrollment_api.service;

import com.axlgutierrezl.enrollment_api.dto.StudentDTO;
import com.axlgutierrezl.enrollment_api.model.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IStudentService extends ICRUD<Student, StudentDTO, Integer>{
    Page<StudentDTO> getAllPaginationByAgeSort(String sort, Pageable pageable) throws Exception;
}
