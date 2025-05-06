package com.cdac.hss.repository;

import com.cdac.hss.entities.WordEntry;
import com.cdac.hss.entities.WordOrigin;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WordOriginRepository extends JpaRepository<WordOrigin, Integer> {
    //WordOrigin findByWordEntry(WordEntry wordEntry);
}
