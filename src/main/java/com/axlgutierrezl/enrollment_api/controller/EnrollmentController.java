package com.axlgutierrezl.enrollment_api.controller;

import com.axlgutierrezl.enrollment_api.dto.EnrollmentDTO;
import com.axlgutierrezl.enrollment_api.service.IEnrollmentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Map;

@RequestMapping("/v1/enrollments")
@RestController
@RequiredArgsConstructor
@Slf4j
public class EnrollmentController {

    private final IEnrollmentService enrollmentService;

    @GetMapping()
    public ResponseEntity<List<EnrollmentDTO>> getAll() throws Exception {
        log.info("EnrollmentController - received request to getAll enrollments ");
        List<EnrollmentDTO> enrollments = this.enrollmentService.getAll();
        return ResponseEntity.ok(enrollments);
    }

    @GetMapping("/pagination")
    public ResponseEntity<Page<EnrollmentDTO>> getAllPagination(Pageable pageable) throws Exception {
        log.info("EnrollmentController - received request to getAllPagination enrollments ");
        Page<EnrollmentDTO> enrollments = this.enrollmentService.getAllPagination(pageable);
        return ResponseEntity.ok(enrollments);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EnrollmentDTO> getById(@PathVariable Integer id) throws Exception {
        log.info("EnrollmentController - received request to getById enrollment {}", id);
        EnrollmentDTO enrollment = this.enrollmentService.getById(id);
        return ResponseEntity.ok(enrollment);
    }

    @PostMapping
    public ResponseEntity<EnrollmentDTO> save(@Valid @RequestBody EnrollmentDTO enrollmentDTO) throws Exception {
        log.info("EnrollmentController - received request to save enrollment {}", enrollmentDTO);
        EnrollmentDTO enrollment = this.enrollmentService.save(enrollmentDTO);
        URI location = URI.create("/v1/enrollments/" + enrollment.getId());
        return ResponseEntity.created(location).body(enrollment);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EnrollmentDTO> update(@PathVariable Integer id, @Valid @RequestBody EnrollmentDTO enrollmentDTO) throws Exception {
        log.info("EnrollmentController - received request to update enrollment {} with id {}", enrollmentDTO, id);
        EnrollmentDTO enrollment = this.enrollmentService.update(id, enrollmentDTO);
        return ResponseEntity.ok(enrollment);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) throws Exception {
        log.info("EnrollmentController - received request to delete enrollment {}", id);
        this.enrollmentService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/students/courses")
    public ResponseEntity<Map<String, List<String>>> getStudentsByCourse() throws Exception {
        log.info("EnrollmentController - received request to getStudentsByCourse enrollments ");
        Map<String, List<String>> enrollments = this.enrollmentService.getStudentsByCourse();
        return ResponseEntity.ok(enrollments);
    }

}
