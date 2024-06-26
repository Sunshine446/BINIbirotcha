package com.sunshine.co.BINI.STORE.Controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sunshine.co.BINI.STORE.Model.Product;
import com.sunshine.co.BINI.STORE.Repository.ProductRepository;


@RestController
public class ProductController {

    ProductRepository repo;

    public ProductController(ProductRepository repo) {
        this.repo = repo;
    }

     //http://127.0.0.1/products
    //Get all Products
    @GetMapping("/products")
    public List<Product> getProduct(){
        return repo.findAll();
    }

   /*  public Product getProduct(Long id){
        return repo.findById(id);
    } */

    //POST ENDPOINT

    //http:127.0.0.1:8080/product/new
    @PostMapping("/product/new")
    public String addProduct(@RequestBody Product newProduct){
        repo.save(newProduct);
        return "A new product is added. Yey!";
    }
     
    //UPDATE ENDPOINTS
    //http://127.0.0.1:8080/product/edit/1
   @PutMapping("/product/edit/{id}") 
   public Product updateProduct(@PathVariable Long id, @RequestBody Product newProduct){
        return repo.findById(id)
        .map(product ->{
            product.setProductName(newProduct.getProductName());
            product.setDescription(newProduct.getDescription());
            product.setPrice(newProduct.getPrice());
            return repo.save(product);
        }).orElseGet(()->{
            return repo.save(newProduct);
        });
   }

    //DELETE ENDPOINTS
    //http://127.0.0.1:8080/product/delete/1
    @DeleteMapping("/product/delete/{id}")
    public String deleteProduct(@PathVariable Long id){
        repo.deleteById(id);
        return "A product is deleted!";
    }
}
