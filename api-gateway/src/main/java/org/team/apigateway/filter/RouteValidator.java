package org.team.apigateway.filter;

import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.function.Predicate;


/**
 * Класс проверяющий, пришел пользователь за регистрацией, или он хочет пройти уже имею токен
 */
@Component
public class RouteValidator {

    // установим список url, от которых AuthFilter не будет ждать аутентификации
    // ведь эти адреса нужны для регистрации
    public static final List<String> openApiEndpoints = List.of(
            "/auth/register",
            "/auth/token",
            "/eureka"
    );

    //почему-то ServerHttpRequest обязательно должен быть с реактивного стека
    //проверка на то, что uri запросов не содержит адресов из openApiEndpoints и подлежит проверке
    public Predicate<ServerHttpRequest> isSecured =
            request -> openApiEndpoints
                    .stream()
                    .noneMatch(uri -> request.getURI().getPath().contains(uri));
}
