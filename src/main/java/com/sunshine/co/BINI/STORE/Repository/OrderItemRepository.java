package com.sunshine.co.BINI.STORE.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sunshine.co.BINI.STORE.Model.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long>{

}
