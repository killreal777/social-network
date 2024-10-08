package org.team.userservice.controller;

import lombok.RequiredArgsConstructor;
import org.team.userservice.dto.AuthRequest;
import org.team.userservice.model.User;
import org.team.userservice.service.auth.AuthService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;
    private final AuthenticationManager authenticationManager;

    @PostMapping("/register")
    public String addNewUser(@RequestBody User user) {
        return authService.saveUser(user);
    }

    @GetMapping("/token")
    public String getToken(@RequestBody AuthRequest authRequest) {
        try {
            Authentication authentication = authenticationManager
                    .authenticate(new UsernamePasswordAuthenticationToken(
                            authRequest.getUsername(), authRequest.getPassword()));

            if (authentication.isAuthenticated()) {
                System.out.println("тут");
                return authService.generateToken(authRequest.getUsername());
            } else {
                throw new RuntimeException("Отказано в доступе");
            }
        } catch (Exception e) {
            e.printStackTrace(); // Вывод ошибки в консоль для диагностики
            throw new RuntimeException("Ошибка аутентификации", e);
        }
    }

    @GetMapping("/validate")
    public String validateToken(@RequestParam("token") String token) {
        authService.validateToken(token);
        return "Токен является валидным";
    }
}
