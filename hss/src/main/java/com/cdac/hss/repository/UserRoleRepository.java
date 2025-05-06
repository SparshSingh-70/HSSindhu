package com.cdac.hss.repository;

import com.cdac.hss.entities.UserRole;
import com.cdac.hss.entities.UserRoleId;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRoleRepository extends JpaRepository<UserRole, UserRoleId> {
    List<UserRole> findByUserUserId(int userId);
}
