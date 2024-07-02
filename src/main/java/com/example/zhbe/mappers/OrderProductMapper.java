package com.example.zhbe.mappers;


import com.example.zhbe.entities.OrderProduct;
import com.example.zhbe.models.OrderProductModel;

public class OrderProductMapper {
    public static OrderProductModel toModel(OrderProduct entity)
    {
        return OrderProductModel.builder()
                .order(OrderMapper.toModel(entity.getOrder()))
                .product(ProductMapper.toModel(entity.getProduct()))
                .quantity(entity.getQuantity())
                .build();
    }
}
