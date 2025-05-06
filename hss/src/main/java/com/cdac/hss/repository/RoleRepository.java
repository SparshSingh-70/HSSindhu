package com.cdac.hss.repository;

import com.cdac.hss.entities.Role;
import com.cdac.hss.enums.RoleName;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Integer> {
    Role findByName(RoleName name);
}
