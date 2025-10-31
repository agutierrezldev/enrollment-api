package com.axlgutierrezl.enrollment_api.validation.role;

import com.axlgutierrezl.enrollment_api.dto.RoleDTO;

public interface IRoleValidationRule {
    void validate(RoleDTO roleDTO);
}
