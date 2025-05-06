package com.cdac.hss.repository;

import com.cdac.hss.entities.PartOfSpeech;
import com.cdac.hss.entities.WordEntry;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PartOfSpeechRepository extends JpaRepository<PartOfSpeech, Integer> {

   // PartOfSpeech findByWordEntry(WordEntry wordEntry);

}
