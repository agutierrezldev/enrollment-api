package com.axlgutierrezl.enrollment_api.controller;

import com.axlgutierrezl.enrollment_api.dto.EnrollmentDTO;
import com.axlgutierrezl.enrollment_api.dto.StudentDTO;
import com.axlgutierrezl.enrollment_api.service.IStudentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RequestMapping("/v1/students")
@RestController
@RequiredArgsConstructor
@Slf4j
public class StudentController {

    private final IStudentService studentService;

    @GetMapping()
    public ResponseEntity<List<StudentDTO>> getAll() throws Exception {
        log.info("StudentController - received request to getAll students ");
        List<StudentDTO> students = this.studentService.getAll();
        return ResponseEntity.ok(students);
    }

    @GetMapping("/pagination")
    public ResponseEntity<Page<StudentDTO>> getAllPagination(Pageable pageable) throws Exception {
        log.info("StudentController - received request to getAllPagination students ");
        Page<StudentDTO> students = this.studentService.getAllPagination(pageable);
        return ResponseEntity.ok(students);
    }

    @GetMapping("/{id}")
    public ResponseEntity<StudentDTO> getById(@PathVariable Integer id) throws Exception {
        log.info("StudentController - received request to getById student {}", id);
        StudentDTO student = this.studentService.getById(id);
        return ResponseEntity.ok(student);
    }

    @PostMapping
    public ResponseEntity<StudentDTO> save(@Valid @RequestBody StudentDTO studentDTO) throws Exception {
        log.info("StudentController - received request to save student {}", studentDTO);
        StudentDTO student = this.studentService.save(studentDTO);
        URI location = URI.create("/v1/students/" + student.getId());
        return ResponseEntity.created(location).body(student);
    }

    @PutMapping("/{id}")
    public ResponseEntity<StudentDTO> update(@PathVariable Integer id, @Valid @RequestBody StudentDTO studentDTO) throws Exception {
        log.info("StudentController - received request to update student {} with id {}", studentDTO, id);
        StudentDTO student = this.studentService.update(id, studentDTO);
        return ResponseEntity.ok(student);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) throws Exception {
        log.info("StudentController - received request to delete student {}", id);
        this.studentService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/pagination/age/{sort}")
    public ResponseEntity<Page<StudentDTO>> getAllPaginationByAgeSort(@PathVariable String sort, Pageable pageable) throws Exception {
        log.info("EnrollmentController - received request to getAllPaginationByAgeSort students ");
        Page<StudentDTO> students = this.studentService.getAllPaginationByAgeSort(sort, pageable);
        return ResponseEntity.ok(students);
    }


}
