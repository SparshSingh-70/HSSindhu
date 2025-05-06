package com.cdac.hss.service;

import com.cdac.hss.entities.UserRole;
import com.cdac.hss.repository.UserRepository;
import com.cdac.hss.repository.UserRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomUserDetailsImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserRoleRepository userRoleRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        com.cdac.hss.entities.User user = userRepository.findByEmail(username);

        if (user == null) {
            throw new UsernameNotFoundException("User not found with email: " + username);
        }


        List<GrantedAuthority> authorities = new ArrayList<>();
        for (UserRole userRole : user.getUserRoles()) {
            authorities.add(new SimpleGrantedAuthority("ROLE_" + userRole.getRole().getName().name()));
        }

        return new org.springframework.security.core.userdetails.User(
                user.getEmail(),
                user.getPassword(),
                authorities
        );

        /*List<UserRole> userRoles = userRoleRepository.findByUserUserId(user.getUserId());

        List<GrantedAuthority> authorities = new ArrayList<>();
        for (UserRole userRole : userRoles) {
            authorities.add(new SimpleGrantedAuthority("ROLE_" + userRole.getRole().getName()));
        }

        return new org.springframework.security.core.userdetails.User(
                user.getEmail(),
                user.getPassword(),
                authorities
        );*/
    }
}