package org.example.apigatewayservice.filter;

import org.example.apigatewayservice.util.JwtUtil;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;

/**
 * Фильтр шлюза, который проверит содержание заголовка авторизации и его валидность
 * В случае если это был запрос на регистрацию, он переадресует его на сервис пользователей
 */
@Component
public class AuthenticationFilter extends AbstractGatewayFilterFactory<AbstractGatewayFilterFactory.NameConfig> {

    private final RouteValidator routeValidator;

    private final JwtUtil jwtUtil;

    public AuthenticationFilter(RouteValidator routeValidator, JwtUtil jwtUtil) {
        this.routeValidator = routeValidator;
        this.jwtUtil = jwtUtil;
    }

    @Override
    public GatewayFilter apply(AbstractGatewayFilterFactory.NameConfig config) {
        return ((exchange, chain) -> {
            if(routeValidator.isSecured.test(exchange.getRequest())){
                // проверка на отсутствие заголовка авторизации
                if(!exchange.getRequest().getHeaders().containsKey(HttpHeaders.AUTHORIZATION)){
                    throw new RuntimeException("Отсутствие заголовка авторизации");
                }

                String authHeader = exchange.getRequest().getHeaders().get(HttpHeaders.AUTHORIZATION).get(0);
                if(authHeader != null && authHeader.startsWith("Bearer ")){
                    authHeader = authHeader.substring(7);
                }
                try {
                    // тут можно сделать вызов на сервис пользователей, но из-за моментов с нагрузкой, лучше проверить сразу в шлюзе
                    jwtUtil.validateToken(authHeader);

                } catch (Exception e) {
                    System.out.println("Ошибка доступа");
                    throw new RuntimeException("В доступе отказано");
                }
            }
            return chain.filter(exchange);
        });
    }

}
