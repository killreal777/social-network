package org.example.datatestservice.repository;

import org.example.datatestservice.model.UserCredentials;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserCredentials, Long> {
}
