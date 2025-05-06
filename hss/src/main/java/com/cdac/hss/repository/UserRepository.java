package com.cdac.hss.repository;

import com.cdac.hss.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User,Integer> {
    User findByEmail(String email);
    Boolean existsByEmail(String email);
   // List<User> findByNameStartingWith(String prefix);

}
