package com.cdac.hss.repository;

import com.cdac.hss.entities.ExpertType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface ExpertTypeRepository extends JpaRepository<ExpertType, Integer> {


}