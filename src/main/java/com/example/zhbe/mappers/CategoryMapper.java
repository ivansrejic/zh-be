package com.example.zhbe.mappers;

import com.example.zhbe.entities.Category;
import com.example.zhbe.models.CategoryModel;

public class CategoryMapper {
    public static Category toEntity(CategoryModel model)
    {
        Category category = new Category();
        category.setId(model.getId());
        category.setName(model.getName());
        category.setDescription(model.getDescription());

        return category;
    }

    public static CategoryModel toModel(Category entity)
    {
        return CategoryModel.builder()
                .id(entity.getId())
                .name(entity.getName())
                .description(entity.getDescription())
                .build();
    }
}
