package com.cdac.hss.service;

import com.cdac.hss.entities.WordEntry;
import com.cdac.hss.repository.WordEntryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WordEntryService {

    @Autowired
    private WordEntryRepository wordEntryRepository;

    public List<WordEntry> getAllWordEntries() {
        return wordEntryRepository.findAll();
    }

    public WordEntry getWordEntryById(int vid) {
        return wordEntryRepository.findById(vid).orElse(null);
    }

    public WordEntry saveWordEntry(WordEntry wordEntry) {
        return wordEntryRepository.save(wordEntry);
    }

    public void deleteWordEntry(int vid) {
        wordEntryRepository.deleteById(vid);
    }


}
