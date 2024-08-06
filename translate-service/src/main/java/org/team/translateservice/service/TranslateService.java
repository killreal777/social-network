package org.team.translateservice.service;

import java.util.Map;

public interface TranslateService {
    Map<String, String> listLanguages();

    String translate(String text, String targetLanguageCode);
}
