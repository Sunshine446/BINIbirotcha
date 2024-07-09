package com.sunshine.co.BINI.STORE.Controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sunshine.co.BINI.STORE.Model.OrderItem;
import com.sunshine.co.BINI.STORE.NotFoundException.OrderItemNotFoundException;
import com.sunshine.co.BINI.STORE.Repository.OrderItemRepository;

@RestController
@RequestMapping("/api/v1/orderItem")
public class OrderItemController {

    OrderItemRepository repo;

    public OrderItemController(OrderItemRepository repo) {
        this.repo = repo;
    }

    // http://127.0.0.1:8080/OrderItem
    // Get all OrderItem
    @GetMapping("/all")
    public List<OrderItem> getOrderItem() {
        return repo.findAll();
    }

    //GET ONE
    // http://127.0.0.1:8080/OrderItem/1
    @GetMapping("/{id}")
    public OrderItem getOrderItem(@PathVariable Long id) {
        return repo.findById(id)
        .orElseThrow(() -> new OrderItemNotFoundException(id));
    }

    // CREATE
    // http:127.0.0.1:8080/OrderItem/new
    @PostMapping("/new")
    public String addOrderItem(@RequestBody OrderItem newOrderItem) {
        repo.save(newOrderItem);
        return "A new OrderItem is added. Yey!";
    }

    // DELETE ENDPOINTS
    // http://127.0.0.1:8080/OrderItem/delete/1
    @DeleteMapping("/delete/{id}")
    public String OrderItem(@PathVariable Long id) {
        repo.deleteById(id);
        return "A OrderItem is deleted!";
    }
}
