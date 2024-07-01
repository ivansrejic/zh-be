package com.example.zhbe.services;

import com.example.zhbe.models.CategoryModel;

import java.util.List;

public interface ICategoryService {
    List<CategoryModel> findAll();
    CategoryModel find(Integer categoryId);
    CategoryModel create(CategoryModel category);
    CategoryModel update(CategoryModel category);
    void delete(Integer categoryId);
}
