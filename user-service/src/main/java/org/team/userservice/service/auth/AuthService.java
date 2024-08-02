package org.team.userservice.service.auth;

import lombok.RequiredArgsConstructor;
import org.team.userservice.model.User;
import org.team.userservice.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final UserRepository repository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;

    public String saveUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword())); // шифруем пароль пользователя
        repository.save(user);
        return "new user add to system";
    }

    /**
     * Генерация JWT токена
     */
    public String generateToken(String username) {
        return jwtService.generateToken(username);
    }

    /**
     * Валидация JWT токена
     */
    public void validateToken(String token) {
        jwtService.validateToken(token);
    }
}
