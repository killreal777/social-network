package org.team.translateservice.yandex.translate.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.team.translateservice.yandex.translate.dto.*;

@FeignClient(name = "yandex-translate", url = "https://translate.api.cloud.yandex.net/translate/v2")
public interface YandexTranslateClient {
    @PostMapping("/detect")
    DetectLanguageResponse detectLanguage(@RequestBody DetectLanguageRequest detectLanguageRequest);

    @PostMapping("/languages")
    ListLanguagesResponse listLanguages();

    @PostMapping("/translate")
    TranslateResponse translate(@RequestBody TranslateRequest translateRequest);
}
