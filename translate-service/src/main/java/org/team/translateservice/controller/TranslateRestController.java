package org.team.translateservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/translate")
public class TranslateRestController {
    @GetMapping
    public String hello() {
        return "Hello translate-service";
    }
}
