package com.cdac.hss.repository;

import com.cdac.hss.entities.WordEntry;
import com.cdac.hss.entities.WordSynonym;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WordSynonymRepository extends JpaRepository<WordSynonym, Integer> {
    List<WordSynonym> findByWordEntry(WordEntry wordEntry);
}

