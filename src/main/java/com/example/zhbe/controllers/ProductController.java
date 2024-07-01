package com.example.zhbe.controllers;

import com.example.zhbe.models.ProductCategoryModel;
import com.example.zhbe.models.ProductModel;
import com.example.zhbe.services.IProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("product")
@RequiredArgsConstructor
@CrossOrigin("*")
public class ProductController {
    private final IProductService productService;

    @GetMapping("all")
    public List<ProductCategoryModel> getProducts()
    {
        return productService.findAll();
    }

    @GetMapping
    public ProductModel getProduct(@RequestParam Integer id)
    {
        return productService.find(id);
    }

    @PostMapping
    public ResponseEntity<?> createProduct(@RequestBody @Valid ProductModel productModel, BindingResult result)
    {
        if(result.hasErrors()) return new ResponseEntity<>("Not created", HttpStatus.INTERNAL_SERVER_ERROR);
        return ResponseEntity.ok(productService.create(productModel));
    }

    @PutMapping
    public ResponseEntity<?> updateProduct(@RequestBody @Valid ProductModel productModel,BindingResult result)
    {
        if(result.hasErrors()) return new ResponseEntity<>("Not updated",HttpStatus.INTERNAL_SERVER_ERROR);
        return ResponseEntity.ok(productService.update(productModel));
    }

    @DeleteMapping()
    public ResponseEntity<?> deleteProduct(@RequestParam Integer id)
    {
        productService.delete(id);
        return ResponseEntity.ok("Product deleted successfully");
    }

}
