package com.products.productservice.controllers;

import com.products.productservice.dtos.GenericProductDtos;
import com.products.productservice.models.Product;
import com.products.productservice.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.*;

@RestController()
@RequestMapping("/products")
public class ProductController {
    //@Autowired
    //field autowired
    private ProductService productService;

    public ProductController(@Qualifier("fakeStoreProductService") ProductService productService){
        this.productService=productService;

    }

    // GET /products {}
    @GetMapping
    public List<GenericProductDtos> getAllProducts() {
        return productService.getAllProducts();
    }

    @PostMapping
    public GenericProductDtos createProduct( GenericProductDtos product) {

//
    }
    //Setter Injection
   // @Autowired
    //public void setProductService(ProductService productService){
      //  this.productService=productService;
    //}




    //localhost:8080/products/123
    @GetMapping("{id}")
    public GenericProductDtos getProductByID(@PathVariable("id") Long id){
        return productService.getProductById(id);
    }



    @DeleteMapping("{id}")
    public GenericProductDtos deleteProductByID(@PathVariable("id") Long id){
        return  productService.deleleteProductByID(id);
    }



    @PutMapping("{id}")
    public void updatePrudctByID(){}





}
