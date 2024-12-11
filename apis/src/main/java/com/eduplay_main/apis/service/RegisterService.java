package com.eduplay_main.apis.service;

import com.eduplay_main.apis.DTO.RegisterDTO;
import com.eduplay_main.apis.model.Login;
import com.eduplay_main.apis.repository.LoginRepository;
import com.eduplay_main.apis.repository.RegisterRepository;
import com.eduplay_main.apis.model.Register;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RegisterService {

    @Autowired
    private RegisterRepository registerRepository;

    @Autowired
    private LoginRepository loginRepository;

    public String registerUser(RegisterDTO registerDTO){
        Optional<Register> existingUser=registerRepository.findByEmail(registerDTO.getEmail());
        if(existingUser.isPresent()){
            return "Email already exists";
        }

        Register register = new Register();
        register.setFullname(registerDTO.getFullname());
        register.setEmail(registerDTO.getEmail());
        register.setPassword(registerDTO.getPassword());
        register.setFavSubject(registerDTO.getFavSubject());

        registerRepository.save(register);

        Login login = new Login();
        login.setEmail(registerDTO.getEmail());
        login.setPassword(registerDTO.getPassword());

        loginRepository.save(login);

        return "Registration successful";
    }
}
