package com.example.zhbe.models;

import com.example.zhbe.entities.User;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class OrderModel {
    private Integer id;

    private User user;

    //Not finished


}
