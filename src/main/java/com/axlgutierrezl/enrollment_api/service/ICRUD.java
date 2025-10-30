package com.axlgutierrezl.enrollment_api.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ICRUD<T, D, ID> {
    Page<D> getAllPagination(Pageable pageable) throws Exception;

    List<D> getAll() throws Exception;

    D getById(ID id) throws Exception;

    D save(D dto) throws Exception;

    D update(ID id, D dto) throws Exception;

    void delete(ID id) throws Exception;
}
