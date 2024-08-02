package org.team.userservice.service;

import org.team.userservice.model.UserCredentials;
import org.team.userservice.repository.UserCredentialsRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private final UserCredentialsRepository userCredentialsRepository;

    public UserService(UserCredentialsRepository userCredentialsRepository) {
        this.userCredentialsRepository = userCredentialsRepository;
    }


    public UserCredentials saveUser(UserCredentials userCredentialsDTO) {
        UserCredentials userCredentials = new UserCredentials();
        userCredentials.setUsername(userCredentialsDTO.getUsername());
        userCredentials.setEmail(userCredentialsDTO.getEmail());
        userCredentials = userCredentialsRepository.save(userCredentials);
        userCredentialsDTO.setId(userCredentials.getId());
        return userCredentialsDTO;
    }

    public Optional<UserCredentials> getUserById(Long id) {
        return userCredentialsRepository.findById(id)
                .map(userCredentials -> {
                    UserCredentials dto = new UserCredentials();
                    dto.setId(userCredentials.getId());
                    dto.setUsername(userCredentials.getUsername());
                    dto.setEmail(userCredentials.getEmail());
                    return dto;
                });
    }


}
