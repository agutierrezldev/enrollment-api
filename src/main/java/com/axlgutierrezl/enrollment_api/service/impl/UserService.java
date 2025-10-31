package com.axlgutierrezl.enrollment_api.service.impl;

import com.axlgutierrezl.enrollment_api.dto.UserDTO;
import com.axlgutierrezl.enrollment_api.mapper.UserMapper;
import com.axlgutierrezl.enrollment_api.model.User;
import com.axlgutierrezl.enrollment_api.repository.IUserRepository;
import com.axlgutierrezl.enrollment_api.repository.IGenericRepository;
import com.axlgutierrezl.enrollment_api.service.IUserService;
import com.axlgutierrezl.enrollment_api.validation.user.IUserValidationRule;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService extends CRUD<User, UserDTO, Integer> implements IUserService {

    private final IUserRepository iUserRepository;
    private final UserMapper studentMapper;
    private final List<IUserValidationRule> validations;

    @Override
    protected IGenericRepository<User, Integer> genericRepository() {
        return this.iUserRepository;
    }

    @Override
    protected User convertEntity(UserDTO dto) {
        return this.studentMapper.convertEntity(dto);
    }

    @Override
    protected UserDTO convertDTO(User user) {
        return this.studentMapper.convertDto(user);
    }

    @Override
    protected void validation(UserDTO userDto) {
        validations.forEach(rule -> rule.validate(userDto));
    }
}
