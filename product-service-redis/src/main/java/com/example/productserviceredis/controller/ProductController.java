package com.example.productserviceredis.controller;

import com.example.productserviceredis.entity.Product;
import com.example.productserviceredis.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductService productService;

    @PostMapping("")
    public Product addProduct(@RequestBody Product product){
        return productService.createProduct(product);
    }

    @GetMapping("")
    public List<Product> getListProduct() {
        List<Product> productList = (List<Product>) productService.listProduct();
        return productList;
    }
    @GetMapping("/{id}")
    public Product getProductById(@PathVariable int id){
        Product product = productService.getProductById(id);
        return product;
    }
    @DeleteMapping("/{id}")
    public boolean deleteProductById(@PathVariable int id){
        return productService.deleteProductById(id);
    }

}