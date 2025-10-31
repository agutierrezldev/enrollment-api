package com.axlgutierrezl.enrollment_api.validation.user;

import com.axlgutierrezl.enrollment_api.dto.UserDTO;

public interface IUserValidationRule {
    void validate(UserDTO userDTO);
}
