package com.axlgutierrezl.enrollment_api.repository;

import com.axlgutierrezl.enrollment_api.model.User;

import java.util.Optional;

public interface IUserRepository extends IGenericRepository<User, Integer> {
    Optional<User> findOneByUsername(String username);
}
