package com.axlgutierrezl.enrollment_api.repository;

import com.axlgutierrezl.enrollment_api.model.Course;

import java.util.Optional;

public interface ICourseRepository extends IGenericRepository<Course, Integer> {
    Optional<Course> findByNameAndAbbr(String name, String abbr);
}
