package com.axlgutierrezl.enrollment_api.mapper;

import com.axlgutierrezl.enrollment_api.dto.RoleDTO;
import com.axlgutierrezl.enrollment_api.model.Role;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class RoleMapper {

    private final ModelMapper modelMapper;

    public Role convertEntity(RoleDTO roleDTO) {
        return this.modelMapper.map(roleDTO, Role.class);
    }

    public RoleDTO convertDto(Role role) {
        return this.modelMapper.map(role, RoleDTO.class);
    }

}
