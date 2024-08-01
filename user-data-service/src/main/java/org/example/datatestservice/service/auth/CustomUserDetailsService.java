package org.example.datatestservice.service.auth;

import org.example.datatestservice.model.UserCredentials;
import org.example.datatestservice.repository.UserCredentialsRepository;
import org.example.datatestservice.security.CustomUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class CustomUserDetailsService implements UserDetailsService {

    //todo лучше через конструктор
    @Autowired
    private UserCredentialsRepository userCredentialsRepository;

    /**
     * Метод позволяющий загружать юзеров из нашей бд в хранилище Spring Security
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<UserCredentials> credentials = userCredentialsRepository.findByUsername(username);
        //переводим наши сущности в объекты spring security
        return credentials.map(CustomUserDetails::new).orElseThrow(() -> new UsernameNotFoundException("User not found with name :" + username));
    }
}
