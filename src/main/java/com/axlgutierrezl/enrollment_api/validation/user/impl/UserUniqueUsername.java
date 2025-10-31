package com.axlgutierrezl.enrollment_api.validation.user.impl;

import com.axlgutierrezl.enrollment_api.dto.UserDTO;
import com.axlgutierrezl.enrollment_api.exception.BusinessValidationException;
import com.axlgutierrezl.enrollment_api.repository.IUserRepository;
import com.axlgutierrezl.enrollment_api.validation.user.IUserValidationRule;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class UserUniqueUsername implements IUserValidationRule {

    private final IUserRepository iUserRepository;

    @Override
    public void validate(UserDTO userDTO) {
        log.info("UserValidation - starting rule UserUniqueFirstNameAndLastNameRule operation with data: {}", userDTO);
        this.iUserRepository.findOneByUsername(userDTO.getUsername())
                .ifPresent(user -> {
                    if (!user.getId().equals(userDTO.getId())) {
                        throw new BusinessValidationException("User with Username " + userDTO.getUsername() + " exits.");
                    }
                });
    }
}
