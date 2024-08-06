package org.team.translateservice.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.team.translateservice.service.TranslateService;

import java.util.Map;

@RestController
@RequestMapping("/api/translate")
@RequiredArgsConstructor
public class TranslateRestController {
    private final TranslateService translateService;

    @GetMapping("/languages")
    public ResponseEntity<Map<String, String>> listLanguages() {
        return ResponseEntity.ok(translateService.listLanguages());
    }

    @PostMapping("/translate")
    public ResponseEntity<String> translate(@RequestParam String text, @RequestParam String targetLanguageCode) {
        return ResponseEntity.ok(translateService.translate(text, targetLanguageCode));
    }
}
