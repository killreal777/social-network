package org.example.datatestservice.controller;

import org.example.datatestservice.dto.AuthRequest;
import org.example.datatestservice.model.UserCredentials;
import org.example.datatestservice.service.auth.AuthService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private AuthService authService;

    private AuthenticationManager authenticationManager;


    public AuthController(AuthService authService, AuthenticationManager authenticationManager) {
        this.authService = authService;
        this.authenticationManager = authenticationManager;
    }

    @PostMapping("/register")
    public String addNewUser(@RequestBody UserCredentials user){
        return authService.saveUser(user);
    }


    @PostMapping("/token")
    public String getToken(@RequestBody AuthRequest authRequest){
        try {
            Authentication authentication = authenticationManager
                    .authenticate(new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword()));

            if (authentication.isAuthenticated()){
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

    public String validateToken(@RequestParam("token") String token){
        authService.validateToken(token);
        return "Токен является валидным";
    }



}
