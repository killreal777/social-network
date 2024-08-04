package org.team.translateservice.yandex.translate.dto;

import lombok.Data;

@Data
public class Translation {
    private String text;

    private String detectedLanguageCode;
}
