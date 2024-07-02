package com.example.zhbe.services;

import com.example.zhbe.entities.Order;
import com.example.zhbe.exceptions.BaseException;
import com.example.zhbe.mappers.OrderMapper;
import com.example.zhbe.models.OrderModel;
import com.example.zhbe.models.OrderProductModel;
import com.example.zhbe.repositories.IUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

//@Service
//@RequiredArgsConstructor
//public class OrderProductService implements IOrderProductService{
//
//    public final IUserRepository userRepository;
//    @Override
//    public List<OrderProductModel> findAll() {
//        return null;
//    }
//
//    @Override
//    public OrderProductModel create(OrderModel orderModel) {
//        var user = userRepository.findById(orderModel.getUserId()).orElseThrow(()->new BaseException("Error"));
//        Order order = OrderMapper.toEntity(orderModel,user);
//
//
//
//
//    }
//}
