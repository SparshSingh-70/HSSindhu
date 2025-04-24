package com.cdac.hss.repository;

import com.cdac.hss.entities.Domain;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DomainRepository  extends JpaRepository<Domain, Integer> {
}
