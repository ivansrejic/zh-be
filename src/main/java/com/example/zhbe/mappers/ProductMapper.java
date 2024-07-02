package com.example.zhbe.mappers;

import com.example.zhbe.entities.Category;
import com.example.zhbe.entities.Product;
import com.example.zhbe.models.ProductModel;
import lombok.RequiredArgsConstructor;


import java.util.ArrayList;
import java.util.List;

public class ProductMapper {

    public static Product toEntity(ProductModel productModel,Category category)
    {
        Product product = new Product();
        product.setId(productModel.getId());
        product.setName(productModel.getName());
        product.setDescription(productModel.getDescription());
        product.setPrice(productModel.getPrice());
        product.setQuantityAvailable(productModel.getQuantityAvailable());
        product.setCategoryId(category);

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
                .categoryId(entity.getCategoryId().getId())
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
