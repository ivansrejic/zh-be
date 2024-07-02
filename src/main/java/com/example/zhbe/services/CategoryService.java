package com.example.zhbe.services;

import com.example.zhbe.exceptions.BaseException;
import com.example.zhbe.mappers.CategoryMapper;
import com.example.zhbe.models.CategoryModel;
import com.example.zhbe.repositories.ICategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryService implements ICategoryService {

    private final ICategoryRepository categoryRepository;
    @Override
    public List<CategoryModel> findAll() {
        var categories = new ArrayList<CategoryModel>();

        var result = categoryRepository.findAll();
        for(var category : result)
        {
            categories.add(CategoryMapper.toModel(category));
        }

        return categories;
    }

    @Override
    public CategoryModel find(Integer categoryId) {
        var category = categoryRepository.findById(categoryId).orElseThrow(()->new BaseException("Category not found"));
        return CategoryMapper.toModel(category);
    }

    @Override
    public CategoryModel create(CategoryModel categoryModel) {
        var categoryEntity = CategoryMapper.toEntity(categoryModel);
        var existing = categoryRepository.findByName(categoryEntity.getName());
        if(existing.isPresent())
        {
            throw new BaseException("Category already exists");
        }
        var savedCategory = categoryRepository.save(categoryEntity);
        return CategoryMapper.toModel(savedCategory);
    }

    @Override
    public CategoryModel update(CategoryModel user) {
        return null;
    }

    @Override
    public void delete(Integer productId) {
    }
}
