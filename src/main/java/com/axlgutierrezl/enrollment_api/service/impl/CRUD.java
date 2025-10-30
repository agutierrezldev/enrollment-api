package com.axlgutierrezl.enrollment_api.service.impl;

import com.axlgutierrezl.enrollment_api.exception.ModelNotFoundException;
import com.axlgutierrezl.enrollment_api.repository.IGenericRepository;
import com.axlgutierrezl.enrollment_api.service.ICRUD;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.lang.reflect.Method;
import java.util.List;

@Slf4j
public abstract class CRUD<T, D, ID> implements ICRUD<T, D, ID> {

    protected abstract IGenericRepository<T, ID> genericRepository();

    protected abstract T convertEntity(D dto);

    protected abstract D convertDTO(T entity);

    protected abstract void validation(D dto);

    @Override
    public Page<D> getAllPagination(Pageable pageable) throws Exception {
        return this.genericRepository().findAll(pageable)
                .map(this::convertDTO);
    }

    @Override
    public List<D> getAll() throws Exception {
        return this.genericRepository().findAll()
                .stream().map(this::convertDTO).toList();
    }

    @Override
    public D getById(ID id) throws Exception {
        return this.genericRepository().findById(id)
                .map(this::convertDTO)
                .orElseThrow(() -> new ModelNotFoundException("ID not found " + id));
    }

    @Override
    public D save(D dto) throws Exception {
        this.validation(dto);
        return this.convertDTO(this.genericRepository().save(this.convertEntity(dto)));
    }

    @Override
    public D update(ID id, D dto) throws Exception {
        String className = dto.getClass().getSimpleName().replace("DTO", "");
        log.info("{}Service - starting update operation with data: {}", className, dto);

        this.genericRepository().findById(id)
                .orElseThrow(() -> new ModelNotFoundException("ID NOT FOUND: " + id));

        Method setIdMethod = dto.getClass().getMethod("setId", id.getClass());
        setIdMethod.invoke(dto, id);

        log.info("{}Service - successfully update operation with data (dto update): {}", className, dto);
        this.validation(dto);
        return this.convertDTO(this.genericRepository().save(this.convertEntity(dto)));
    }

    @Override
    public void delete(ID id) throws Exception {
        this.genericRepository().findById(id)
                .orElseThrow(() -> new ModelNotFoundException("ID NOT FOUND: " + id));
        this.genericRepository().deleteById(id);
    }
}
