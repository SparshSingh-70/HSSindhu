package com.cdac.hss.repository;

import com.cdac.hss.entities.WordEntry;
import com.cdac.hss.entities.WordUsage;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WordUsageRepository extends JpaRepository<WordUsage, Integer> {
    List<WordUsage> findByWordEntry(WordEntry wordEntry);
}

