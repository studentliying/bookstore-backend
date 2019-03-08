package com.example.springboot.controller;

import com.example.springboot.entity.BookEntity;
import com.example.springboot.entity.CartEntity;
import com.example.springboot.entity.UserEntity;
import com.example.springboot.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequestMapping(value="/Cart")
public class CartController {

    @Autowired
    private CartService cartService;

    @RequestMapping(value = "/addToCart")
    private String processAddToCart(@RequestParam("bookname") String bookname,
                                    HttpServletResponse response, HttpSession session) {
        //System.out.println("session in addToCart:"+session.getId());
        String username="";
        if (session.getAttribute("user")!=null) {
            username = (((UserEntity) session.getAttribute("user")).getUsername());
            //String userbook = username + bookname;
            //System.out.println(userbook);
        }
        return cartService.addToCart(username, bookname);
    }

    @RequestMapping(value = "/showcart")
    private List<CartEntity> processShowcart(@RequestParam("username") String username,
                                             HttpServletResponse response, HttpSession session) {
        System.out.println("request success");
        return cartService.showCart(username);
    }

    @RequestMapping(value = "/judgeState")
    private String processJudgestate(HttpServletResponse response, HttpSession session) {
        //System.out.println("sessionid2:"+session.getId());
        //System.out.println(((UserEntity) session.getAttribute("user")).getUsername());
        if (session.getAttribute("user")!=null) {

            String result = (((UserEntity)session.getAttribute("user")).getUsername());
            return result;
        }
        else{
            System.out.println("2");
            return "Not logon";
        }
    }


}