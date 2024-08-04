package org.team.translateservice.yandex.translate.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TranslateRequest {
    private String targetLanguageCode;

    private List<String> texts;
}
