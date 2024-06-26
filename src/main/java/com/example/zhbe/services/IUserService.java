package com.example.zhbe.services;

import com.example.zhbe.models.UserModel;

import java.util.List;

public interface IUserService {
    List<UserModel> findAll();
    UserModel find(Integer userId);
    UserModel create(UserModel user);
    UserModel update(UserModel user);
    void delete(Integer userId);
}
