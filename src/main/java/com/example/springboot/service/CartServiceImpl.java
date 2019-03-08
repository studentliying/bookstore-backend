package com.example.springboot.service;

import com.example.springboot.dao.BookDao;
import com.example.springboot.dao.CartDao;
import com.example.springboot.entity.BookEntity;
import com.example.springboot.entity.CartEntity;
import com.example.springboot.util.IdVerifier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Scope("prototype")
public class CartServiceImpl implements CartService {

    @Autowired
    private CartDao cartRepo;
    @Autowired
    private BookDao bookRepo;


    public String addToCart(String username, String bookname) {
        List<BookEntity> list = bookRepo.queryByBookname(bookname);
        BookEntity book = list.get(0);
        int oldAmount = book.getAmount();
        if (oldAmount == 0) {
            return "Not enough";
        } else {
            int newAmount = oldAmount - 1;
            int temp = bookRepo.updateAmount(newAmount, bookname);
            CartEntity cartitem = new CartEntity();
            System.out.println(username+bookname);
            cartitem.setUserbook(username+bookname);
            cartitem.setUsername(username);
            cartitem.setBookname(bookname);
            cartitem.setAuthor(book.getAuthor());
            cartitem.setAmount(1);
            cartitem.setPrice(book.getPrice());
            cartRepo.save(cartitem);
            return "Success";
        }
    }

    public List<CartEntity> showCart(String username) {
        List<CartEntity> list = cartRepo.queryByUsername(username);
        System.out.println("booklist size:"+list.size());
        return list;
    }
}
