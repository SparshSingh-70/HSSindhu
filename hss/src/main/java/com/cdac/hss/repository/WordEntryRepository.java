package com.cdac.hss.repository;

import com.cdac.hss.entities.WordEntry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface WordEntryRepository  extends JpaRepository<WordEntry, Integer> {
    List<WordEntry> findByWordContaining(String query);
    List<WordEntry> findByWordContainingAndIsLiveTrue(String query);
    List<WordEntry> findByWordAndIsLiveTrue(String word);

    @Query("SELECT w FROM WordEntry w WHERE LOWER(TRIM(w.word)) = LOWER(TRIM(:word)) AND w.isLive = true")
    WordEntry findCleanedWordExactMatch(@Param("word") String word);
}