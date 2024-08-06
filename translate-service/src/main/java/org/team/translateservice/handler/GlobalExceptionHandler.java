package org.team.translateservice.handler;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import feign.FeignException;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
@RequiredArgsConstructor
public class GlobalExceptionHandler {
    private final ObjectMapper objectMapper;

    @ExceptionHandler
    public ResponseEntity<Object> handleFeignException(FeignException ex) {
        return new ResponseEntity<>(extractMessage(ex), HttpStatusCode.valueOf(ex.status()));
    }

    @SneakyThrows
    private String extractMessage(FeignException ex) {
        JsonNode rootNode = objectMapper.readTree(ex.contentUTF8());
        return rootNode.get("message").asText();
    }
}
