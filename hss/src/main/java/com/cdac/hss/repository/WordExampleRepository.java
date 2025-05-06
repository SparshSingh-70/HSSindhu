package com.cdac.hss.repository;

import com.cdac.hss.entities.WordEntry;
import com.cdac.hss.entities.WordExample;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WordExampleRepository extends JpaRepository<WordExample, Integer> {
    List<WordExample> findByWordEntry(WordEntry wordEntry);
}
