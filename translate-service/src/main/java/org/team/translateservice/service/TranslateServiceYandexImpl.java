package org.team.translateservice.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.team.translateservice.yandex.translate.client.YandexTranslateClient;
import org.team.translateservice.yandex.translate.dto.TranslateRequest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class TranslateServiceYandexImpl implements TranslateService {
    private final YandexTranslateClient yandexTranslateClient;

    @Override
    public Map<String, String> listLanguages() {
        Map<String, String> languages = new HashMap<>();

        yandexTranslateClient.listLanguages().getLanguages()
                .forEach(lang -> languages.put(lang.getCode(), lang.getName()));

        return languages;
    }

    @Override
    public String translate(String text, String targetLanguageCode) {
        return yandexTranslateClient.translate(new TranslateRequest(targetLanguageCode, List.of(text)))
                .getTranslations().get(0).getText();
    }
}
