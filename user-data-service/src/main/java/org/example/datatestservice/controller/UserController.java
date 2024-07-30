package org.example.datatestservice.controller;


import org.example.datatestservice.model.UserCredentials;
import org.example.datatestservice.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@RestController
@RequestMapping("/data/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }


    @PostMapping
    public ResponseEntity<String> createUser(@RequestBody UserCredentials userCredentials) {
        UserCredentials savedUserCredentials = userService.saveUser(userCredentials);
        String message = String.format("Пользователь с ID %d успешно создан!", savedUserCredentials.getId());
        return ResponseEntity.ok(message);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserCredentials> getUser(@PathVariable Long id) {
        Optional<UserCredentials> userDTO = userService.getUserById(id);
        return userDTO.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
