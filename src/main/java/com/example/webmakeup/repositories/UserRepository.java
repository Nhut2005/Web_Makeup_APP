package com.example.webmakeup.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;
import com.example.webmakeup.models.User;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
    boolean existsByUsername(String username);
}