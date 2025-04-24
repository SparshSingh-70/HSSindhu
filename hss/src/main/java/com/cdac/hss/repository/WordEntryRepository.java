package com.cdac.hss.repository;

import com.cdac.hss.entities.WordEntry;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WordEntryRepository  extends JpaRepository<WordEntry, Integer> {
}