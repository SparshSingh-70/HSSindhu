package com.cdac.hss.service;

import com.cdac.hss.entities.*;
import com.cdac.hss.repository.*;
import com.cdac.hss.response.WordResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class WordService {

    private final WordEntryRepository wordEntryRepository;
    private final WordMeaningRepository wordMeaningRepository;
    private final WordProverbRepository wordProverbRepository;
    private final WordSynonymRepository wordSynonymRepository;
    private final WordUsageRepository wordUsageRepository;
    private final WordExampleRepository wordExampleRepository;
    private final PartOfSpeechRepository partOfSpeechRepository;
    private final WordOriginRepository wordOriginRepository;
    private final WordDomainMappingRepository wordDomainMappingRepository;
    private final WordSubdomainMappingRepository wordSubdomainMappingRepository;

    /*
        Method 1: To find All the words with Matching Query String
    */

    public List<WordResponse> searchWords(String query) {
        List<WordEntry> entries = wordEntryRepository.findByWordContainingAndIsLiveTrue(query);

        return entries.stream()
                .map(this::convertToResponse)
                .collect(Collectors.toList());
    }

    private WordResponse convertToResponse(WordEntry entry) {
        WordResponse response = new WordResponse();

        response.setWord(entry.getWord());

        response.setEnglishTranslation(entry.getEnglish_translation());

        response.setMeanings(
                wordMeaningRepository.findByWordEntry(entry)
                        .stream()
                        .map(WordMeaning::getMeaning)
                        .collect(Collectors.toList())
        );

        response.setProverbs(
                wordProverbRepository.findByWordEntry(entry)
                        .stream()
                        .map(WordProverb::getProverb)
                        .collect(Collectors.toList())
        );

        response.setSynonyms(
                wordSynonymRepository.findByWordEntry(entry)
                        .stream()
                        .map(WordSynonym::getSynonym)
                        .collect(Collectors.toList())
        );

        response.setUses(
                wordUsageRepository.findByWordEntry(entry)
                        .stream()
                        .map(WordUsage::getWordUse)
                        .collect(Collectors.toList())
        );

        response.setExamples(
                wordExampleRepository.findByWordEntry(entry)
                        .stream()
                        .map(WordExample::getExample)
                        .collect(Collectors.toList())
        );

        // Set Part of Speech (direct from the entry's partOfSpeech relationship)
        response.setPartOfSpeech(entry.getPartOfSpeech() != null ? entry.getPartOfSpeech().getName() : null);

        // Set Word Origin (direct from the entry's origin relationship)
        response.setOrigin(entry.getOrigin() != null ? entry.getOrigin().getOriginName() : null);

        response.setDomains(
                wordDomainMappingRepository.findByWordEntry(entry)
                        .stream()
                        .map(mapping -> mapping.getDomain().getName())
                        .collect(Collectors.toList())
        );

        response.setSubdomains(
                wordSubdomainMappingRepository.findByWordEntry(entry)
                        .stream()
                        .map(mapping -> mapping.getSubdomain().getName())
                        .collect(Collectors.toList())
        );

        return response;
    }



    /*
    Method 2: To find Word Details of the Matching Query Word
     */

    public WordResponse getWordDetails(String word) {
        List<WordEntry> listEntry = wordEntryRepository.findByWordContainingAndIsLiveTrue(word);
        /*System.out.println("list->" + listEntry.toString());*/
        if (listEntry.isEmpty()) {
           // System.out.println("Inside getWordDetails listEntry.isEmpty()");
            return null; // or throw a custom NotFoundException
        }

        WordEntry entry = listEntry.get(0);
        WordResponse response = new WordResponse();

        response.setWord(entry.getWord());

        response.setMeanings(
                wordMeaningRepository.findByWordEntry(entry).stream()
                        .map(WordMeaning::getMeaning)
                        .collect(Collectors.toList())
        );

        response.setProverbs(
                wordProverbRepository.findByWordEntry(entry).stream()
                        .map(WordProverb::getProverb)
                        .collect(Collectors.toList())
        );

        response.setSynonyms(
                wordSynonymRepository.findByWordEntry(entry).stream()
                        .map(WordSynonym::getSynonym)
                        .collect(Collectors.toList())
        );

        response.setUses(
                wordUsageRepository.findByWordEntry(entry).stream()
                        .map(WordUsage::getWordUse)
                        .collect(Collectors.toList())
        );

        response.setExamples(
                wordExampleRepository.findByWordEntry(entry).stream()
                        .map(WordExample::getExample)
                        .collect(Collectors.toList())
        );

        // Set Part of Speech (direct from the entry's partOfSpeech relationship)
        response.setPartOfSpeech(entry.getPartOfSpeech() != null ? entry.getPartOfSpeech().getName() : null);

        // Set Word Origin (direct from the entry's origin relationship)
        response.setOrigin(entry.getOrigin() != null ? entry.getOrigin().getOriginName() : null);

        response.setDomains(
                wordDomainMappingRepository.findByWordEntry(entry).stream()
                        .map(mapping -> mapping.getDomain().getName())
                        .collect(Collectors.toList())
        );

        response.setSubdomains(
                wordSubdomainMappingRepository.findByWordEntry(entry).stream()
                        .map(mapping -> mapping.getSubdomain().getName())
                        .collect(Collectors.toList())
        );

        //return response;
        List<WordResponse> wordResponses = searchWords(word.trim());
        return wordResponses.get(0);
    }
}
