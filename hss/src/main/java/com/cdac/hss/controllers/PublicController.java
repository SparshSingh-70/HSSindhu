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

    @GetMapping("/searchAll")
    public ResponseEntity<List<WordResponse>> getWordsList(@RequestParam String query){
        List<WordResponse> wordResponses = wordService.searchWords(query.trim());
        System.out.println("First Line");
        return new ResponseEntity<>(wordResponses, HttpStatus.OK);
    }

    @GetMapping("/search")
    public ResponseEntity<WordResponse> getSingleWord(@RequestParam String query) {
        System.out.println("First Line");
        WordResponse response = wordService.getWordDetails(query.trim());
        System.out.println("Second Line");
        if (response == null) {
            System.out.println("Inside response == null");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}

