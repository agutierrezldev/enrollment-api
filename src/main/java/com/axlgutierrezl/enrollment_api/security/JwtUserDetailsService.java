package com.axlgutierrezl.enrollment_api.security;

import com.axlgutierrezl.enrollment_api.model.User;
import com.axlgutierrezl.enrollment_api.repository.IUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class JwtUserDetailsService implements UserDetailsService {

    private final IUserRepository iUserRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = this.iUserRepository.findOneByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("Username NOT FOUND: " + username));


        List<GrantedAuthority> roles = new ArrayList<>();
        String rol = user.getRole().getName();
        roles.add(new SimpleGrantedAuthority(rol));

        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), roles);
    }
}
