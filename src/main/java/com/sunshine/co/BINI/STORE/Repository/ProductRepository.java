package com.sunshine.co.BINI.STORE.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sunshine.co.BINI.STORE.Model.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{

}