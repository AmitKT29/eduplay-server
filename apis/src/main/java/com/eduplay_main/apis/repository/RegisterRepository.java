package com.eduplay_main.apis.repository;

import com.eduplay_main.apis.model.Register;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RegisterRepository extends JpaRepository<Register , Long> {
    Optional<Register> findByEmail(String email);
}
