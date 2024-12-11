package com.eduplay_main.apis.service;

import com.eduplay_main.apis.DTO.LoginDTO;
import com.eduplay_main.apis.repository.LoginRepository;
import com.eduplay_main.apis.model.Login;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LoginService {

    @Autowired
    private LoginRepository loginRepository;

    public String loginUser(LoginDTO loginDTO){

        Optional<Login> user = loginRepository.findByEmail(loginDTO.getEmail());
        if(user.isEmpty()){
            return "User not found";
        }

        Login login = user.get();

        if(login.getPassword().equals(loginDTO.getPassword())){
            return "Login successful";
        }

        return "Invalid password";
    }
}
