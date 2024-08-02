package org.team.userservice.service;

import lombok.RequiredArgsConstructor;
import org.team.userservice.model.User;
import org.team.userservice.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public User saveUser(User userDto) {
        User user = User.builder()
                .username(userDto.getUsername())
                .email(userDto.getEmail())
                .build();
        user = userRepository.save(user);
        userDto.setId(user.getId());
        return userDto;
    }

    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }
}
