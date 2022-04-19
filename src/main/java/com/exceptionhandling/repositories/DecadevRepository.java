package com.exceptionhandling.repositories;

import com.exceptionhandling.models.Decadev;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DecadevRepository extends JpaRepository<Decadev, Long> {
    Optional<Decadev> findByEmail(String email);
}
