package com.axlgutierrezl.enrollment_api.controller;

import com.axlgutierrezl.enrollment_api.dto.CourseDTO;
import com.axlgutierrezl.enrollment_api.service.ICourseService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RequestMapping("/v1/courses")
@RestController
@RequiredArgsConstructor
@Slf4j
public class CourseController {

    private final ICourseService courseService;

    @GetMapping()
    public ResponseEntity<List<CourseDTO>> getAll() throws Exception {
        log.info("CourseController - received request to getAll courses ");
        List<CourseDTO> courses = this.courseService.getAll();
        return ResponseEntity.ok(courses);
    }

    @GetMapping("/pagination")
    public ResponseEntity<Page<CourseDTO>> getAllPagination(Pageable pageable) throws Exception {
        log.info("CourseController - received request to getAllPagination courses ");
        Page<CourseDTO> courses = this.courseService.getAllPagination(pageable);
        return ResponseEntity.ok(courses);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CourseDTO> getById(@PathVariable Integer id) throws Exception {
        log.info("CourseController - received request to getById course {}", id);
        CourseDTO course = this.courseService.getById(id);
        return ResponseEntity.ok(course);
    }

    @PostMapping
    public ResponseEntity<CourseDTO> save(@Valid @RequestBody CourseDTO courseDTO) throws Exception {
        log.info("CourseController - received request to save course {}", courseDTO);
        CourseDTO course = this.courseService.save(courseDTO);
        URI location = URI.create("/v1/specialty/" + course.getId());
        return ResponseEntity.created(location).body(course);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CourseDTO> update(@PathVariable Integer id, @Valid @RequestBody CourseDTO courseDTO) throws Exception {
        log.info("CourseController - received request to update course {} with id {}", courseDTO, id);
        CourseDTO course = this.courseService.update(id, courseDTO);
        return ResponseEntity.ok(course);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) throws Exception {
        log.info("CourseController - received request to delete course {}", id);
        this.courseService.delete(id);
        return ResponseEntity.noContent().build();
    }


}
