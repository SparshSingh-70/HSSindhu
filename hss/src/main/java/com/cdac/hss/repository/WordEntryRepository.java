package com.cdac.hss.repository;

import com.cdac.hss.entities.WordEntry;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WordEntryRepository  extends JpaRepository<WordEntry, Integer> {
    List<WordEntry> findByWordContaining(String query);
    List<WordEntry> findByWordContainingAndIsLiveTrue(String query);
}