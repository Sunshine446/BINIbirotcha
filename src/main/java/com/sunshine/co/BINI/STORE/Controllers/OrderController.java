package com.sunshine.co.BINI.STORE.Controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sunshine.co.BINI.STORE.Model.Order;
import com.sunshine.co.BINI.STORE.NotFoundException.OrderNotFoundException;
import com.sunshine.co.BINI.STORE.Repository.OrderRepository;

@RestController
@RequestMapping("/api/v1/order")
public class OrderController {

    OrderRepository repo;

    public OrderController(OrderRepository repo) {
        this.repo = repo;
    }

    // http://127.0.0.1:8080/Order
    // Get all Order
    @GetMapping("/all")
    public List<Order> getOrder() {
        return repo.findAll();
    }

    //GET ONE
    // http://127.0.0.1:8080/Order/1
    @GetMapping("/{id}")
    public Order getOrder(@PathVariable Long id) {
        return repo.findById(id)
        .orElseThrow(() -> new OrderNotFoundException(id));
    }

    // CREATE
    // http:127.0.0.1:8080/Order/new
    @PostMapping("/new")
    public String addOrder(@RequestBody Order newOrder) {
        repo.save(newOrder);
        return "A new Order is added. Yey!";
    }

    // DELETE ENDPOINTS
    // http://127.0.0.1:8080/Order/delete/1
    @DeleteMapping("/delete/{id}")
    public String OrderUsers(@PathVariable Long id) {
        repo.deleteById(id);
        return "A Order is deleted!";
    }
}
