package org.example.datatestservice.service;

import org.example.datatestservice.model.UserCredentials;
import org.example.datatestservice.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    public UserCredentials saveUser(UserCredentials userCredentialsDTO) {
        UserCredentials userCredentials = new UserCredentials();
        userCredentials.setUsername(userCredentialsDTO.getUsername());
        userCredentials.setEmail(userCredentialsDTO.getEmail());
        userCredentials = userRepository.save(userCredentials);
        userCredentialsDTO.setId(userCredentials.getId());
        return userCredentialsDTO;
    }

    public Optional<UserCredentials> getUserById(Long id) {
        return userRepository.findById(id)
                .map(userCredentials -> {
                    UserCredentials dto = new UserCredentials();
                    dto.setId(userCredentials.getId());
                    dto.setUsername(userCredentials.getUsername());
                    dto.setEmail(userCredentials.getEmail());
                    return dto;
                });
    }


}
