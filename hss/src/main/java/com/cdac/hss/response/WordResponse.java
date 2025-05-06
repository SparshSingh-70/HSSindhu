package com.cdac.hss.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WordResponse {

    private String word;
    private List<String> meanings;
    private List<String> proverbs;
    private List<String> synonyms;
    private List<String> uses;
    private List<String> examples;
    private String partOfSpeech;
    private String origin;
    private List<String> domains;
    private List<String> subdomains;

}
