package com.cdac.hss.repository;

import com.cdac.hss.entities.WordEntry;
import com.cdac.hss.entities.WordSubdomainMapping;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WordSubdomainMappingRepository extends JpaRepository<WordSubdomainMapping, Integer> {
    List<WordSubdomainMapping> findByWordEntry(WordEntry wordEntry);
}
