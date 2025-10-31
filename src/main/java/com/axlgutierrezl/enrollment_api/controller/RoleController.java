package com.axlgutierrezl.enrollment_api.controller;

import com.axlgutierrezl.enrollment_api.dto.RoleDTO;
import com.axlgutierrezl.enrollment_api.service.IRoleService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RequestMapping("/v1/roles")
@RestController
@RequiredArgsConstructor
@Slf4j
public class RoleController {

    private final IRoleService roleService;

    @GetMapping()
    public ResponseEntity<List<RoleDTO>> getAll() throws Exception {
        log.info("RoleController - received request to getAll roles ");
        List<RoleDTO> roles = this.roleService.getAll();
        return ResponseEntity.ok(roles);
    }

    @GetMapping("/pagination")
    public ResponseEntity<Page<RoleDTO>> getAllPagination(Pageable pageable) throws Exception {
        log.info("RoleController - received request to getAllPagination roles ");
        Page<RoleDTO> roles = this.roleService.getAllPagination(pageable);
        return ResponseEntity.ok(roles);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RoleDTO> getById(@PathVariable Integer id) throws Exception {
        log.info("RoleController - received request to getById role {}", id);
        RoleDTO role = this.roleService.getById(id);
        return ResponseEntity.ok(role);
    }

    @PostMapping
    public ResponseEntity<RoleDTO> save(@Valid @RequestBody RoleDTO roleDTO) throws Exception {
        log.info("RoleController - received request to save role {}", roleDTO);
        RoleDTO role = this.roleService.save(roleDTO);
        URI location = URI.create("/v1/roles/" + role.getId());
        return ResponseEntity.created(location).body(role);
    }

    @PutMapping("/{id}")
    public ResponseEntity<RoleDTO> update(@PathVariable Integer id, @Valid @RequestBody RoleDTO roleDTO) throws Exception {
        log.info("RoleController - received request to update role {} with id {}", roleDTO, id);
        RoleDTO role = this.roleService.update(id, roleDTO);
        return ResponseEntity.ok(role);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) throws Exception {
        log.info("RoleController - received request to delete roles {}", id);
        this.roleService.delete(id);
        return ResponseEntity.noContent().build();
    }


}
