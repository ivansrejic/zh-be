package com.example.zhbe.mappers;

import com.example.zhbe.entities.Order;
import com.example.zhbe.entities.User;
import com.example.zhbe.models.OrderModel;

import java.util.Optional;

public class OrderMapper {

    public static Order toEntity(OrderModel orderModel, User user)
    {
        Order order = new Order();
        order.setId(orderModel.getId());
        order.setUser(user);
        order.setOrderDate(orderModel.getOrderDate());
        order.setTotalAmount(orderModel.getTotalAmount());
        order.setShippingAddress(orderModel.getShippingAddress());
        order.setOrderStatus(orderModel.getOrderStatus());
        order.setShippingDate(orderModel.getShippingDate());
        order.setDeliveryDate(orderModel.getDeliveryDate());
        //order.getOrderProducts()
        //Not finished

        return order;
    }

    public static OrderModel toModel(Order entity)
    {
        return OrderModel.builder()
                .id(entity.getId())
                .userId(entity.getUser().getId())
                .orderDate(entity.getOrderDate())
                .totalAmount(entity.getTotalAmount())
                .shippingAddress(entity.getShippingAddress())
                .orderStatus(entity.getOrderStatus())
                .shippingDate(entity.getShippingDate())
                .deliveryDate(entity.getDeliveryDate())
                .build();
    }
}
