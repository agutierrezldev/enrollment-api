package com.axlgutierrezl.enrollment_api.service.impl;

import com.axlgutierrezl.enrollment_api.dto.RoleDTO;
import com.axlgutierrezl.enrollment_api.mapper.RoleMapper;
import com.axlgutierrezl.enrollment_api.model.Role;
import com.axlgutierrezl.enrollment_api.repository.IGenericRepository;
import com.axlgutierrezl.enrollment_api.repository.IRoleRepository;
import com.axlgutierrezl.enrollment_api.service.IRoleService;
import com.axlgutierrezl.enrollment_api.validation.role.IRoleValidationRule;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RoleService extends CRUD<Role, RoleDTO, Integer> implements IRoleService {

    private final IRoleRepository iRoleRepository;
    private final RoleMapper studentMapper;
    private final List<IRoleValidationRule> validations;

    @Override
    protected IGenericRepository<Role, Integer> genericRepository() {
        return this.iRoleRepository;
    }

    @Override
    protected Role convertEntity(RoleDTO dto) {
        return this.studentMapper.convertEntity(dto);
    }

    @Override
    protected RoleDTO convertDTO(Role role) {
        return this.studentMapper.convertDto(role);
    }

    @Override
    protected void validation(RoleDTO roleDto) {
        validations.forEach(rule -> rule.validate(roleDto));
    }
}
