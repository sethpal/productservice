package com.products.productservice.services;

import com.products.productservice.dtos.FakeStoreProductDtos;
import com.products.productservice.dtos.GenericProductDtos;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RequestCallback;
import org.springframework.web.client.ResponseExtractor;
import org.springframework.web.client.RestTemplate;
import java.util.*;

@Service("fakeStoreProductService")
public class FakeStoreProductService implements ProductService{

    private RestTemplateBuilder restTemplateBuilder;
    private String productServiceBaseUrl ="https://fakestoreapi.com/products";
    private String productServiceSpecificUrl ="https://fakestoreapi.com/products/{id}";
    public FakeStoreProductService(RestTemplateBuilder restTemplateBuilder){
        this.restTemplateBuilder=restTemplateBuilder;

    }
    @Override
    public GenericProductDtos getProductById(Long id) {
        RestTemplate restTemplate=restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductDtos> response=
                restTemplate.getForEntity(productServiceSpecificUrl, FakeStoreProductDtos.class,id);
       FakeStoreProductDtos fakeStoreProductDtos=response.getBody();

        GenericProductDtos product=new GenericProductDtos();
        product.setId(fakeStoreProductDtos.getId());
        product.setDescription(fakeStoreProductDtos.getDescription());
        product.setTitle(fakeStoreProductDtos.getTitle());
        product.setPrice(fakeStoreProductDtos.getPrice());
        product.setImage(fakeStoreProductDtos.getImage());
        product.setCategory(fakeStoreProductDtos.getCategory());
        return product;
    }
    public GenericProductDtos createProduct(){
        return null;
    }

    @Override
     public List<GenericProductDtos> getAllProducts(){
        RestTemplate restTemplate=restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductDtos[]> response=
                restTemplate.getForEntity(productServiceBaseUrl, FakeStoreProductDtos[].class);

        List<GenericProductDtos> answer=new ArrayList<>();
        for(FakeStoreProductDtos fakeStoreProductDtos: response.getBody())
        {
            answer.add(convertFakeStoreProductIntoGenericProduct(fakeStoreProductDtos));
        }
        return answer;
    }

    @Override
    public GenericProductDtos deleleteProductByID(Long id){
        RestTemplate restTemplate=restTemplateBuilder.build();

        RequestCallback requestCallback=restTemplate.acceptHeaderRequestCallback(FakeStoreProductDtos.class);
        ResponseExtractor<ResponseEntity<FakeStoreProductDtos>> responseExtractor=
                restTemplate.responseEntityExtractor(FakeStoreProductDtos.class);

        ResponseEntity<FakeStoreProductDtos> response=
                restTemplate.execute(productServiceSpecificUrl, HttpMethod.DELETE,
                        requestCallback,responseExtractor,id);

        FakeStoreProductDtos fakeStoreProductDtos=response.getBody();

       return  convertFakeStoreProductIntoGenericProduct(fakeStoreProductDtos);
    }

    private GenericProductDtos convertFakeStoreProductIntoGenericProduct(FakeStoreProductDtos fakeStoreProductDtos)
    {
        GenericProductDtos product=new GenericProductDtos();
        product.setId(fakeStoreProductDtos.getId());
        product.setDescription(fakeStoreProductDtos.getDescription());
        product.setTitle(fakeStoreProductDtos.getTitle());
        product.setPrice(fakeStoreProductDtos.getPrice());
        product.setImage(fakeStoreProductDtos.getImage());
        product.setCategory(fakeStoreProductDtos.getCategory());
        return product;
    }

    public GenericProductDtos createProduct( GenericProductDtos product) {
        RestTemplate restTemplate=restTemplateBuilder.build();
        ResponseEntity<GenericProductDtos> response=restTemplate.postForEntity(
                productServiceBaseUrl,product,GenericProductDtos.class);
        return response.getBody();
    }

}
