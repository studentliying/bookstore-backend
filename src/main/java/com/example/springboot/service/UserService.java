package com.example.springboot.service;

import com.example.springboot.entity.CartEntity;
import com.example.springboot.entity.UserEntity;

import java.util.List;

public interface UserService {

    String search(String name, String pwd);

    UserEntity findUser(String name);

    String add(String name, String pwd, String email, String addr, String phone);

}
