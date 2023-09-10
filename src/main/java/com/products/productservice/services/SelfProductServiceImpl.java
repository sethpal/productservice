package com.products.productservice.services;

import com.products.productservice.dtos.GenericProductDtos;

import org.springframework.stereotype.Service;
import java.util.*;

@Service("selfProductServiceImpl")
public class SelfProductServiceImpl implements ProductService{
    @Override
    public GenericProductDtos getProductById(Long id) {
        return null;
    }
    public GenericProductDtos createProduct(){
        return null;
    }
    public List<GenericProductDtos> getAllProducts(){
        return null;
    }

    public GenericProductDtos deleleteProductByID(Long id){
    return null;
    }
}
