package com.github.kiarttantasi.lolapi.controllers;

import com.github.kiarttantasi.lolapi.services.MatchHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/match")
public class MatchHistoryController {

    private final MatchHistoryService matchHistoryService;

    public MatchHistoryController(MatchHistoryService matchHistoryService) {
        this.matchHistoryService = matchHistoryService;
    }

    @GetMapping
    public ResponseEntity<String> getMatches(@RequestParam String gameName, @RequestParam String tagLine) {
        System.out.println("gameName: " + gameName);
        System.out.println("tagLine: " + tagLine);
        final List<String> matches = matchHistoryService.getMatches();
        if (matches == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body("matches");
    }
}