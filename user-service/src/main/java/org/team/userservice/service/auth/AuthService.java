package org.team.userservice.service.auth;


import org.team.userservice.model.UserCredentials;
import org.team.userservice.repository.UserCredentialsRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private UserCredentialsRepository repository;

    private PasswordEncoder passwordEncoder;

    private JwtService jwtService;


    public AuthService(UserCredentialsRepository repository, PasswordEncoder passwordEncoder, JwtService jwtService) {
        this.repository = repository;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
    }

    public String saveUser (UserCredentials userCredentials){
        userCredentials.setPassword(passwordEncoder.encode(userCredentials.getPassword())); // шифруем пароль пользователя
        repository.save(userCredentials);
        return "new user add to system";
    }

    /**
     * Генерация JWT токена
     */
    public String generateToken(String username){
        return jwtService.generateToken(username);
    }

    /**
     * Валидация JWT токена
     */
    public void validateToken(String token) {
        jwtService.validateToken(token);
    }








}
