package com.example.springboot.service;

import com.example.springboot.dao.OrderDao;
import com.example.springboot.entity.OrderEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;


@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderDao orderRepo;

    @Transactional
    public String addOrder(String time, String username, String bookname, int amount, double price, double sum){
        OrderEntity orderitem = new OrderEntity();
        orderitem.setSubmittime(time);
        orderitem.setUsername(username);
        orderitem.setBookname(bookname);
        orderitem.setAmount(amount);
        orderitem.setPrice(price);
        orderitem.setSum(sum);
       orderRepo.save(orderitem);
        return "Success";
    }

    @Transactional
    public List<OrderEntity> getOrder(String username){
        return orderRepo.queryByUsername(username);
    }
}
