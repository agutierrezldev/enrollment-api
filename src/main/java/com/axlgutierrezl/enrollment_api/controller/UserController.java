package com.axlgutierrezl.enrollment_api.controller;

import com.axlgutierrezl.enrollment_api.dto.UserDTO;
import com.axlgutierrezl.enrollment_api.service.IUserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RequestMapping("/v1/users")
@RestController
@RequiredArgsConstructor
@Slf4j
public class UserController {

    private final IUserService userService;

    @GetMapping()
    public ResponseEntity<List<UserDTO>> getAll() throws Exception {
        log.info("UserController - received request to getAll users ");
        List<UserDTO> users = this.userService.getAll();
        return ResponseEntity.ok(users);
    }

    @GetMapping("/pagination")
    public ResponseEntity<Page<UserDTO>> getAllPagination(Pageable pageable) throws Exception {
        log.info("UserController - received request to getAllPagination users ");
        Page<UserDTO> users = this.userService.getAllPagination(pageable);
        return ResponseEntity.ok(users);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> getById(@PathVariable Integer id) throws Exception {
        log.info("UserController - received request to getById user {}", id);
        UserDTO user = this.userService.getById(id);
        return ResponseEntity.ok(user);
    }

    @PostMapping
    public ResponseEntity<UserDTO> save(@Valid @RequestBody UserDTO userDTO) throws Exception {
        log.info("UserController - received request to save user {}", userDTO);
        UserDTO user = this.userService.save(userDTO);
        URI location = URI.create("/v1/users/" + user.getId());
        return ResponseEntity.created(location).body(user);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserDTO> update(@PathVariable Integer id, @Valid @RequestBody UserDTO userDTO) throws Exception {
        log.info("UserController - received request to update user {} with id {}", userDTO, id);
        UserDTO user = this.userService.update(id, userDTO);
        return ResponseEntity.ok(user);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) throws Exception {
        log.info("UserController - received request to delete users {}", id);
        this.userService.delete(id);
        return ResponseEntity.noContent().build();
    }


}
