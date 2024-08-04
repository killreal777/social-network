package org.team.translateservice.service;

import java.util.Map;

public interface TranslateService {
    String detectLanguage(String text);

    Map<String, String> listLanguages();

    String translate(String text, String languageCode);
}
