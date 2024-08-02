package org.team.userservice.controller;

import lombok.RequiredArgsConstructor;
import org.team.userservice.model.User;
import org.team.userservice.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

/**
 * Контроллер временно не используется
 */
@RestController
@RequestMapping("/data/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping
    public ResponseEntity<String> createUser(@RequestBody User user) {
        User savedUser = userService.saveUser(user);
        String message = String.format("Пользователь с ID %d успешно создан!", savedUser.getId());
        return ResponseEntity.ok(message);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUser(@PathVariable Long id) {
        Optional<User> userDto = userService.getUserById(id);
        return userDto.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
