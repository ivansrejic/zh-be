package com.example.zhbe.services;

import com.example.zhbe.exceptions.UserException;
import com.example.zhbe.models.UserModel;
import com.example.zhbe.repositories.IUserRepository;
import jdk.jshell.spi.ExecutionControl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService implements IUserService {
    private final IUserRepository userRepository;
    @Override
    public List<UserModel> findAll() {
        var result = userRepository.findAll();
        return null;//Mapiraj podatke u Model
    }

    @Override
    public UserModel find(Integer userId) {
        var user = userRepository.findById(userId).orElseThrow(()->new UserException("User not found"));
        return null;
    }

    @Override
    public UserModel create(UserModel user) {
        return null;
    }

    @Override
    public UserModel update(UserModel user) {
        return null;
    }

    @Override
    public void delete(Integer userId) {
        var user = userRepository.findById(userId).orElseThrow(() -> new UserException("User not found"));
    }
}
