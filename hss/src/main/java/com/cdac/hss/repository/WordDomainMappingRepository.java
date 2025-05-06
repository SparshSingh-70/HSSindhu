package com.cdac.hss.repository;

import com.cdac.hss.entities.WordDomainMapping;
import com.cdac.hss.entities.WordEntry;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WordDomainMappingRepository extends JpaRepository<WordDomainMapping,Integer> {

    List<WordDomainMapping> findByWordEntry(WordEntry wordEntry);
}
