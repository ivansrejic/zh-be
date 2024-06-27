package com.example.zhbe.services;

import com.example.zhbe.exceptions.BaseException;
import com.example.zhbe.exceptions.UserException;
import com.example.zhbe.mappers.UserMapper;
import com.example.zhbe.models.UserModel;
import com.example.zhbe.repositories.IUserRepository;
import jdk.jshell.spi.ExecutionControl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService implements IUserService {
    private final IUserRepository userRepository;
    @Override
    public List<UserModel> findAll() {
        var users = new ArrayList<UserModel>();

        var result = userRepository.findAll();
        for(var user : result)
        {
            users.add(UserMapper.toModel(user));
        }
        return users;
    }

    @Override
    public UserModel find(Integer userId) {
        var user = userRepository.findById(userId).orElseThrow(()->new UserException("User not found"));
        return UserMapper.toModel(user);
    }

    @Override
    public UserModel create(UserModel user) {
        var userEntity = UserMapper.toEntity(user);
        var existingUser = userRepository.findByEmail(user.getEmail());
        if(existingUser.isPresent())
        {
            throw new BaseException("User with email " + user.getEmail() + " already exists");
        }

        var savedUser = userRepository.save(userEntity);

        return UserMapper.toModel(savedUser);
    }


    @Override
    public UserModel update(UserModel user) {
        var userEntity = UserMapper.toEntity(user);
        try {
            var result = userRepository.save(userEntity);
            return UserMapper.toModel(result);
        } catch (Exception e) {
            throw new UserException(e.getMessage());
        }
    }

    @Override
    public void delete(Integer userId) {
        var user = userRepository.findById(userId).orElseThrow(() -> new UserException("User not found"));
        userRepository.delete(user);
    }
}
