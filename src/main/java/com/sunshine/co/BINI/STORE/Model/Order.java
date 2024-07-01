package com.sunshine.co.BINI.STORE.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "ordertbl")
public class Order {
    
    private @Id
    @GeneratedValue Long orderId;
    private Long userId;
    private double totalAmount;
    private String status;

    //Constructors
    Order(){}

    public Order(Long orderId, Long userId, double totalAmount, String status){
        this.orderId = orderId;
        this.userId = userId;
        this.totalAmount = totalAmount;
        this.status = status;
    } 

    //getters

    public Long getorderId(){
        return orderId;
    }
    
    public Long getuserId(){
        return userId;
    }

    public double gettotalAmount(){
        return totalAmount;
    }

    public String getStatus(){
        return status;
    }

    //setters
    public void setorderId(Long orderId){
        this.orderId = orderId;
    }

    public void setuserId(Long userId){
        this.userId = userId;
    }

    public void settotalAmount(double totalAmount){
        this.totalAmount = totalAmount;
    }

    public void setstatus(String status){
        this.status = status;
    }

}
