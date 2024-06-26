package com.example.zhbe.mappers;

import com.example.zhbe.entities.Product;
import com.example.zhbe.models.ProductModel;

import java.util.ArrayList;
import java.util.List;

public class ProductMapper {
    public static Product toEntity(ProductModel productModel)
    {
        Product product = new Product();
        product.setId(product.getId());
        product.setName(product.getName());
        product.setDescription(product.getDescription());
        product.setPrice(product.getPrice());
        product.setQuantityAvailable(product.getQuantityAvailable());
        return product;
    }

    public static ProductModel toModel(Product entity)
    {
        return ProductModel.builder()
                .id(entity.getId())
                .name(entity.getName())
                .description(entity.getDescription())
                .price(entity.getPrice())
                .quantityAvailable(entity.getQuantityAvailable())
                .build();
    }

    public static List<ProductModel> toModelList(List<Product> entities)
    {
        var list = new ArrayList<ProductModel>();
        for(var entity : entities)
        {
            list.add(toModel(entity));
        }
        return list;
    }
}
