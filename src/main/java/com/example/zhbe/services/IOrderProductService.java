package com.example.zhbe.services;

import com.example.zhbe.entities.Order;
import com.example.zhbe.entities.OrderProduct;
import com.example.zhbe.models.OrderModel;
import com.example.zhbe.models.OrderProductModel;

import java.util.List;

public interface IOrderProductService {
    List<OrderProductModel> findAll();

    OrderProductModel create(OrderModel order);

}
