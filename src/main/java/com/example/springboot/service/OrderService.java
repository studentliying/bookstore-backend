package com.example.springboot.service;

import com.example.springboot.entity.OrderEntity;

import java.util.List;

public interface OrderService {

    String addOrder(String time, String username, String bookname, int amount, double price, double sum);

    List<OrderEntity> getOrder(String username);
}
