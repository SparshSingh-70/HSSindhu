package com.cdac.hss.repository;

import com.cdac.hss.entities.WordEntry;
import com.cdac.hss.entities.WordProverb;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WordProverbRepository extends JpaRepository<WordProverb, Integer> {
    List<WordProverb> findByWordEntry(WordEntry wordEntry);
}