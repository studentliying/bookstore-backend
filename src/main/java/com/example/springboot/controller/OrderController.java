package com.example.springboot.controller;

import com.example.springboot.entity.OrderEntity;
import com.example.springboot.entity.UserEntity;
import com.example.springboot.service.OrderService;
import com.example.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequestMapping(value="/Order")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @RequestMapping(value = "/submitOrder")
    private String processSubmitOrder(@RequestParam("time") String time,
                                      @RequestParam("bookname") String bookname,
                                      @RequestParam("amount") int amount,
                                      @RequestParam("price") double price,
                                      @RequestParam("sum") double sum,
                                    HttpServletResponse response, HttpSession session) {
        String username="";
        if (session.getAttribute("user")!=null) {
            username = (((UserEntity) session.getAttribute("user")).getUsername());}
        return orderService.addOrder(time, username, bookname, amount, price, sum);
    }

    @RequestMapping(value = "/getOrder")
    private List<OrderEntity> processGetOrder(HttpServletResponse response, HttpSession session) {
        String username="";
        if (session.getAttribute("user")!=null) {
            username = (((UserEntity) session.getAttribute("user")).getUsername());}
        return orderService.getOrder(username);
    }

    @RequestMapping(value = "/judgeState")
    private String processJudgeState(HttpServletResponse response, HttpSession session) {
        String username="";
        if (session.getAttribute("user")!=null) {
            username = (((UserEntity) session.getAttribute("user")).getUsername());}
        return username;
    }
}
