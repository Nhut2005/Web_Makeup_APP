package com.example.webmakeup.repositories;

import com.example.webmakeup.models.Artist;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ArtistRepository extends JpaRepository<Artist, Long> {
    Optional<Artist> findByName(String name);
    List<Artist> findBySpecialization(String specialization);
}