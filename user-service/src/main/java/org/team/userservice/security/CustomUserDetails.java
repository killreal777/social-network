package org.team.userservice.security;

import org.team.userservice.model.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

/**
 * Класс определяющий сущности, хранящиеся в хранилище Spring Security
 */
public class CustomUserDetails implements UserDetails {
    private final String username;
    private final String password;

    public CustomUserDetails(User user) {
        this.username = user.getUsername();
        this.password = user.getPassword();
    }

    //метод для определения списка ролей пользователя, позже реализуем
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
