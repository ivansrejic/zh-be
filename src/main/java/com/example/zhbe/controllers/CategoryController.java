package com.example.zhbe.controllers;

import com.example.zhbe.models.CategoryModel;
import com.example.zhbe.services.ICategoryService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("category")
@CrossOrigin("*")
public class CategoryController {
    private final ICategoryService categoryService;

    @GetMapping("all")
    public List<CategoryModel> getCategories()
    {
        return categoryService.findAll();
    }

    @GetMapping()
    public CategoryModel getCategory(@RequestParam Integer id)
    {
        return categoryService.find(id);
    }

    @PostMapping()
    public ResponseEntity<?> createCategory(@RequestBody @Valid CategoryModel categoryModel, BindingResult result)
    {
        if(result.hasErrors()) return new ResponseEntity<>("Not created", HttpStatus.INTERNAL_SERVER_ERROR);
        return ResponseEntity.ok(categoryService.create(categoryModel));
    }

}
