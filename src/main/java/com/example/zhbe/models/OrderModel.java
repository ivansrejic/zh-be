package com.example.zhbe.models;

import com.example.zhbe.entities.User;
import com.example.zhbe.enums.OrderStatus;
import lombok.Builder;
import lombok.Data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Builder
public class OrderModel {
    private Integer id;
    private Integer userId;
    private Date orderDate;

    private Double totalAmount;

    private String shippingAddress;

    private OrderStatus orderStatus;

    private Date shippingDate;

    private Date deliveryDate;


}
