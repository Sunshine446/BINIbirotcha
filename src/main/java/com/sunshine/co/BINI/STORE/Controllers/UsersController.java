package com.sunshine.co.BINI.STORE.Controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sunshine.co.BINI.STORE.Model.Users;
import com.sunshine.co.BINI.STORE.NotFoundException.UsersNotFoundException;
import com.sunshine.co.BINI.STORE.Repository.UsersRepository;

@RestController
public class UsersController {

    UsersRepository repo;

    public UsersController(UsersRepository repo) {
        this.repo = repo;
    }

    // http://127.0.0.1:8080/users
    // Get all Users
    @GetMapping("/Users")
    public List<Users> getUsers() {
        return repo.findAll();
    }

    //GET ONE
    // http://127.0.0.1:8080/users/1
    @GetMapping("/Users/{id}")
    public Users getUsers(@PathVariable Long id) {
        return repo.findById(id)
        .orElseThrow(() -> new UsersNotFoundException(id));
    }

    // CREATE
    // http:127.0.0.1:8080/users/new
    @PostMapping("Users/new")
    public String addUsers(@RequestBody Users newUsers) {
        repo.save(newUsers);
        return "A new Users is added. Yey!";
    }

    // UPDATE ENDPOINTS
    // http://127.0.0.1:8080/users/edit/1
    @PutMapping("/Users/edit/{id}")
    public Users updateUsers(@PathVariable Long id,@RequestBody Users newUsers){
        return repo.findById(id)
        .map(users ->{
            users.setName(newUsers.getName());
            users.setYear(newUsers.getYear());
            users.setContact(newUsers.getContact());
            users.setEmail(newUsers.getEmail());
            users.setPassword(newUsers.getPassword());
            return repo.save(users);
        }).orElseGet(()->{
            return repo.save(newUsers);
        });

    }
    // DELETE ENDPOINTS
    // http://127.0.0.1:8080/users/delete/1
    @DeleteMapping("/Users/delete/{id}")
    public String deleteUsers(@PathVariable Long id) {
        repo.deleteById(id);
        return "A users is deleted!";
    }
}
