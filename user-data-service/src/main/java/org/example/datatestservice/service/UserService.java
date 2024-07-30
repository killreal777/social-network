package org.example.datatestservice.service;

import org.example.datatestservice.model.User;
import org.example.datatestservice.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    public User saveUser(User userDTO) {
        User user = new User();
        user.setUsername(userDTO.getUsername());
        user.setEmail(userDTO.getEmail());
        user = userRepository.save(user);
        userDTO.setId(user.getId());
        return userDTO;
    }

    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id)
                .map(user -> {
                    User dto = new User();
                    dto.setId(user.getId());
                    dto.setUsername(user.getUsername());
                    dto.setEmail(user.getEmail());
                    return dto;
                });
    }


}
