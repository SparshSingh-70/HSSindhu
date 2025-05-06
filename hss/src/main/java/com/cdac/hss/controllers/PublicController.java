package com.cdac.hss.controllers;

import com.cdac.hss.response.WordResponse;
import com.cdac.hss.service.WordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/public")
public class PublicController {

    @Autowired
    private WordService wordService;

    @GetMapping("/searchTest")
    public String searchWords() {
        return "Search Words for testing";
    }

    @GetMapping("/search")
    public ResponseEntity<List<WordResponse>> getWordsList(@RequestParam String query){
        List<WordResponse> wordResponses = wordService.searchWords(query);
        return new ResponseEntity<>(wordResponses, HttpStatus.OK);
    }
}

