package com.eduplay_main.apis.controller;

import com.eduplay_main.apis.DTO.LoginDTO;
import com.eduplay_main.apis.DTO.ResponseDTO;
import com.eduplay_main.apis.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private LoginService loginService;

    @PostMapping
    public ResponseEntity<ResponseDTO> loginUser(@RequestBody LoginDTO loginDTO){
        String result = loginService.loginUser(loginDTO);

        if(result.equals("Login successful")){
            return ResponseEntity.ok(new ResponseDTO(true,result));
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(new ResponseDTO(false,result));
    }
}
