package com.example.springboot.service;

import com.example.springboot.entity.CartEntity;

import java.util.List;

public interface CartService {

    String addToCart(String username, String bookname);

    List<CartEntity> showCart(String username);

}
