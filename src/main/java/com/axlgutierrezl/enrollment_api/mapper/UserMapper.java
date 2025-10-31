package com.axlgutierrezl.enrollment_api.mapper;

import com.axlgutierrezl.enrollment_api.dto.UserDTO;
import com.axlgutierrezl.enrollment_api.model.User;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserMapper {

    private final ModelMapper modelMapper;

    public User convertEntity(UserDTO userDTO) {
        return this.modelMapper.map(userDTO, User.class);
    }

    public UserDTO convertDto(User user) {
        return this.modelMapper.map(user, UserDTO.class);
    }

}
