package org.team.translateservice.yandex.translate.dto;

import lombok.Data;

import java.util.List;

@Data
public class TranslateResponse {
    private List<Translation> translations;
}
