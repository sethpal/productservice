package com.products.productservice.dtos;

import lombok.Getter;
import lombok.Setter;
import com.products.productservice.models.BaseModel;

@Setter
@Getter
public class FakeStoreProductDtos {
    private Long id;
    private String title;
    private double price;
    private String description;
    private String image;
    private String category;

}
