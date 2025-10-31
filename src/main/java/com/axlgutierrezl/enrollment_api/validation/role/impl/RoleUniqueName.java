package com.axlgutierrezl.enrollment_api.validation.role.impl;

import com.axlgutierrezl.enrollment_api.dto.RoleDTO;
import com.axlgutierrezl.enrollment_api.exception.BusinessValidationException;
import com.axlgutierrezl.enrollment_api.repository.IRoleRepository;
import com.axlgutierrezl.enrollment_api.validation.role.IRoleValidationRule;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class RoleUniqueName implements IRoleValidationRule {

    private final IRoleRepository iRoleRepository;

    @Override
    public void validate(RoleDTO roleDTO) {
        log.info("RoleValidation - starting rule RoleUniqueName operation with data: {}", roleDTO);
        this.iRoleRepository.findOneByName(roleDTO.getName())
                .ifPresent(role -> {
                    if (!role.getId().equals(roleDTO.getId())) {
                        throw new BusinessValidationException("Role with Name " + roleDTO.getName() + " exits.");
                    }
                });
    }
}
