package com.example.zhbe.services;

import com.example.zhbe.exceptions.BaseException;
import com.example.zhbe.mappers.ProductCategoryMapper;
import com.example.zhbe.mappers.ProductMapper;
import com.example.zhbe.models.ProductCategoryModel;
import com.example.zhbe.models.ProductModel;
import com.example.zhbe.repositories.ICategoryRepository;
import com.example.zhbe.repositories.IProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService implements IProductService {

    private final IProductRepository productRepository;
    private final ICategoryRepository categoryRepository;
    @Override
    public List<ProductCategoryModel> findAll() {
        var products = new ArrayList<ProductCategoryModel>();
        var result = productRepository.findAll();
        for(var product : result)
        {
            products.add(ProductCategoryMapper.toModel(product));
        }
        return products;
    }

    @Override
    public ProductModel find(Integer productId) {
        var product = productRepository.findById(productId).orElseThrow(() -> new BaseException("Product not founnd"));
        return ProductMapper.toModel(product);
    }

    @Override
    public ProductCategoryModel create(ProductModel product) {
        var category = categoryRepository.findById(product.getCategoryId()).orElseThrow(()->new BaseException("Error"));
        var productEntity = ProductMapper.toEntity(product,category);
        var savedProduct = productRepository.save(productEntity);

        return ProductCategoryMapper.toModel(savedProduct);

    }

    @Override
    public ProductCategoryModel update(ProductModel product) {
        var productEntity = ProductMapper.toEntity(product,categoryRepository.findById(product.getCategoryId()).orElseThrow(()->new BaseException("Error")));
        try {
            var result = productRepository.save(productEntity);
            return ProductCategoryMapper.toModel(result);
        }
        catch(Exception e)
        {
            throw new BaseException(e.getMessage());
        }
    }

    @Override
    public void delete(Integer productId) {
        var product = productRepository.findById(productId).orElseThrow(()->new BaseException("Not found"));
        productRepository.delete(product);
    }
}
