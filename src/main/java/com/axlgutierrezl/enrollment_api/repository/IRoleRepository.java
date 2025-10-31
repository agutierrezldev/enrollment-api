package com.axlgutierrezl.enrollment_api.repository;

import com.axlgutierrezl.enrollment_api.model.Role;

import java.util.Optional;

public interface IRoleRepository extends IGenericRepository<Role, Integer> {
    Optional<Role> findOneByName(String name);
}
