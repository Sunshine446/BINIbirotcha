package com.sunshine.co.BINI.STORE.Controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.sunshine.co.BINI.STORE.Model.UserModel;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class UserController {

    //Fetch One Data
    //http://locathost.8080/users
    @GetMapping("/user")
    public UserModel getUserModel(){
       return new UserModel(1, "Jeven 11", "jeven.11@email.com", "jeven11");
    }

    //Fetch Multiple Data
    //http://localhost:8080/users
    @GetMapping("/users")
    public List<UserModel> getUsers(){
        List<UserModel> users = new ArrayList<>();
        users.add(new UserModel(1, "Rendo", "rendo@email.com", "rendo"));
        users.add(new UserModel(2, "Rico", "rico@email.com", "rico"));
        users.add(new UserModel(3, "Dudong", "dudong@email.com", "dudong"));
        return users;
    }
    //http://localhost:8080/user/baby
    @GetMapping("/user/{name}")
    public UserModel getUserFromName(@PathVariable("name")String name){
        return new UserModel(1, "Baby", "baby@email.com", "baby");
    }
}

