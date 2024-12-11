package com.eduplay_main.apis.controller;

import com.eduplay_main.apis.DTO.RegisterDTO;
import com.eduplay_main.apis.DTO.ResponseDTO;
import com.eduplay_main.apis.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/register")
public class RegisterController {

    @Autowired
    private RegisterService registerService;

    @PostMapping
    public ResponseEntity<ResponseDTO> registerUser(@RequestBody RegisterDTO registerDTO){
        String result = registerService.registerUser(registerDTO);

        if(result.equals("Email already exists")){
            return ResponseEntity.status(HttpStatus.CONFLICT).body(new ResponseDTO(false,result));
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(new ResponseDTO(true,result));
    }
}
