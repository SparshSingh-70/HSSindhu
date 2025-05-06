package com.cdac.hss.repository;

import com.cdac.hss.entities.WordEntry;
import com.cdac.hss.entities.WordMeaning;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WordMeaningRepository extends JpaRepository<WordMeaning, Integer> {
    List<WordMeaning> findByWordEntry(WordEntry wordEntry);
}
