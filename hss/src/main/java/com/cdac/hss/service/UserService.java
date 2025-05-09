package com.cdac.hss.service;

import com.cdac.hss.entities.*;
import com.cdac.hss.enums.*;
import com.cdac.hss.enums.ExpertType;
import com.cdac.hss.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.*;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private SubdomainRepository subdomainRepository;

    @Autowired
    private DomainRepository domainRepository;

    @Autowired
    private UserRoleRepository userRoleRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Transactional
    public User registerUser(User user, List<Integer> roles, List<Integer> domains) {
        if (userRepository.existsByEmail(user.getEmail())) {
            throw new RuntimeException("Email already exists");
        }

        user.setPassword(user.getPassword());
        user.setStatus('A');
        user.setCreatedAt(LocalDateTime.now());
        user.setUpdatedAt(LocalDateTime.now());

        User savedUser = userRepository.save(user);

        /*List<UserRole> userRolesList = new ArrayList<>();
        for (Integer roleId : roles) {
            for (Integer domainId : domains) {


                UserRoleId userRoleId = new UserRoleId(savedUser.getUserId(), domainId, roleId, 293);

                UserRole newUserRole = new UserRole(userRoleId, savedUser, roleRepository.findById(roleId).get(),
                       null, domainRepository.findById(domainId).get(),
                        subdomainRepository.findById(293).get());

                userRolesList.add(newUserRole);
            }
        }*/

        List<UserRole> userRolesList = new ArrayList<>();
        Subdomain subdomain = subdomainRepository.findById(293)
                .orElseThrow(() -> new RuntimeException("Subdomain not found"));

        for (Integer roleId : roles) {
            Role role = roleRepository.findById(roleId)
                    .orElseThrow(() -> new RuntimeException("Role not found"));

            for (Integer domainId : domains) {
                Domain domain = domainRepository.findById(domainId)
                        .orElseThrow(() -> new RuntimeException("Domain not found"));

                UserRoleId userRoleId = new UserRoleId(savedUser.getUserId(), domainId, roleId, 293);
                UserRole newUserRole = new UserRole(userRoleId, savedUser, role, null, domain, subdomain);
                userRolesList.add(newUserRole);
            }
        }

        userRoleRepository.saveAll(userRolesList);

        return savedUser;
    }

    public User getUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }
}
