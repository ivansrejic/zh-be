package com.example.zhbe.models;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class OrderProductModel {
    private OrderModel order;

    private ProductModel product;

    private Integer quantity;
}
