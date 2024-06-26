package com.example.zhbe.mappers;

import com.example.zhbe.entities.User;
import com.example.zhbe.models.UserModel;

import java.util.ArrayList;
import java.util.List;

public class UserMapper {
    public static User toEntity(UserModel userModel)
    {
        User user = new User();
        user.setId(userModel.getId());
        user.setFirstName(userModel.getFirstName());
        user.setLastName(userModel.getLastName());
        user.setEmail(userModel.getEmail());
        user.setPassword(userModel.getPassword());
        user.setAddress(userModel.getAddress());
        user.setRegistrationDate(userModel.getRegistrationDate());
        return user;
    }

    public static UserModel toModel(User entity)
    {
        return UserModel.builder()
                .id(entity.getId())
                .firstName(entity.getFirstName())
                .lastName(entity.getLastName())
                .email(entity.getEmail())
                .password(entity.getPassword())
                .address(entity.getAddress())
                .registrationDate(entity.getRegistrationDate())
                .build();
    }

    public static List<UserModel> toModelList(List<User> entities)
    {
        var list = new ArrayList<UserModel>();
        for(var entity : entities)
        {
            list.add(toModel(entity));
        }
        return list;
    }
}
