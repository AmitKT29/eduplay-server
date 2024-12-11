package com.eduplay_main.apis.repository;

import com.eduplay_main.apis.model.Login;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.swing.text.html.Option;
import java.util.Optional;

public interface LoginRepository extends JpaRepository<Login , Long> {
    Optional<Login> findByEmail(String email);
}
