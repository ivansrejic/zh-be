package com.example.zhbe.services;

import com.example.zhbe.models.ProductCategoryModel;
import com.example.zhbe.models.ProductModel;

import java.util.List;

public interface IProductService {
    List<ProductCategoryModel> findAll();
    ProductModel find(Integer productId);

    ProductCategoryModel create(ProductModel product);

    ProductCategoryModel update(ProductModel product);
    void delete(Integer productId);
}
