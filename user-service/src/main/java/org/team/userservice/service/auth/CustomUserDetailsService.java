package org.team.userservice.service.auth;

import lombok.RequiredArgsConstructor;
import org.team.userservice.model.User;
import org.team.userservice.repository.UserRepository;
import org.team.userservice.security.CustomUserDetails;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {
    private final UserRepository userRepository;

    /**
     * Метод позволяющий загружать юзеров из нашей БД в хранилище Spring Security
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> credentials = userRepository.findByUsername(username);
        //переводим наши сущности в объекты spring security
        return credentials.map(CustomUserDetails::new).orElseThrow(() -> new UsernameNotFoundException("User not found with name :" + username));
    }
}
