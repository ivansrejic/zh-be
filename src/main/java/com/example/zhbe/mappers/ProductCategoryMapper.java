package com.example.zhbe.mappers;

import com.example.zhbe.entities.Product;
import com.example.zhbe.models.ProductCategoryModel;

public class ProductCategoryMapper {
    public static ProductCategoryModel toModel(Product product)
    {
        return ProductCategoryModel.builder()
                .id(product.getId())
                .name(product.getName())
                .description(product.getDescription())
                .price(product.getPrice())
                .quantityAvailable(product.getQuantityAvailable())
                .category(CategoryMapper.toModel(product.getCategoryId()))
                .build();
    }
}
