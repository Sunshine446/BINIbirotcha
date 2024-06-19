package com.sunshine.co.BINI.STORE.Controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sunshine.co.BINI.STORE.Model.UserModel;

@RestController
public class UserController {

    @GetMapping("/user")
    public UserModel getUserModel(){
       return new UserModel(1, "Jeven 11", "jeven.11@email.com", "jeven11");
    }
}
