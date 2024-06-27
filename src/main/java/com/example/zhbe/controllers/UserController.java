package com.example.zhbe.controllers;

import com.example.zhbe.models.UserModel;
import com.example.zhbe.services.IUserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("user")
@RequiredArgsConstructor
@CrossOrigin("*")
public class UserController {
    private final IUserService userService;

    @GetMapping("name")
    public String getName()
    {
        return "Ivan";
    }

    @GetMapping("all")
    public List<UserModel> getList()
    {
        return userService.findAll();
    }

    @GetMapping()
    public UserModel getUser(@RequestParam Integer id)
    {
        return userService.find(id);
    }

    @PostMapping("create-user")
    public ResponseEntity<?> createUser(@RequestBody @Valid UserModel userModel, BindingResult result)
    {
        return ResponseEntity.ok(userService.create(userModel));
    }

    @PutMapping("update")
    public ResponseEntity<?> updateUser(@RequestBody @Valid UserModel userModel,BindingResult result)
    {
        if(result.hasErrors()) return new ResponseEntity<>("Not updated",HttpStatus.INTERNAL_SERVER_ERROR);
        return ResponseEntity.ok(userService.update(userModel));
    }

    @DeleteMapping("delete")
    public ResponseEntity<?> deleteUser(@RequestParam Integer id)
    {
        userService.delete(id);
        return ResponseEntity.ok("User deleted successfully");
    }

}
