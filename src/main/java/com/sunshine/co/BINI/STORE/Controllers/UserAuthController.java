package com.sunshine.co.BINI.STORE.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sunshine.co.BINI.STORE.Model.UserAuth;
import com.sunshine.co.BINI.STORE.Repository.UserAuthRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api/v1/auth")
public class UserAuthController {

     @Autowired
     UserAuthRepository userAuthRepository;

     @Autowired
     RoleRepository RoleRepository;

     @Autowired
     PasswordEncoder PasswordEncoder;

     @Autowired
     AuthenticationManager authenticationManager;

     @PostMapping("register")
     public ResponseEntity<?> register(@RequestBody RegistrationRequest RegistrationRequest){

        //check if username exist in DB
        if(userAuthRepository.existsByUsername(registrationRequest.getUsername())){
            return new ResponseEntity<>("Username is already taken!", HttpStatus.BAD_REQUEST);
        }

        if(userAuthRepository.existsByEmail(registrationRequest.getEmail())){
            return new ResponseEntity<>("An account is already registered in this email", HttpStatus.BAD_REQUEST);
        }
     
        UserAuth user = new UserAuth(
            registrationRequest.getUsername(),
            registrationRequest.getEmail(),
            PasswordEncoder.encode(registrationRequest.getPassword())
        );

        Role role = RoleRepository.findByName("ROLE_ADMIN").get();
        user.setRoles(Collections.singleton(role));

        userAuthRepository.save(user);
        return new ResponseEntity<>("User registered succesfully", HttpStatus.OK);
     }
     
}
