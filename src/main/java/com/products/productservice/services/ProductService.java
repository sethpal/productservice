package com.products.productservice.services;

import com.products.productservice.dtos.GenericProductDtos;

import java.util.*;

public interface ProductService {
    public GenericProductDtos getProductById(Long id);
    public GenericProductDtos createProduct();
    public List<GenericProductDtos> getAllProducts();

    public GenericProductDtos deleleteProductByID(Long id);
}
