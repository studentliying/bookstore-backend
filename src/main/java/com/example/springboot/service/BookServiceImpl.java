package com.example.springboot.service;

import com.example.springboot.dao.BookDao;
import com.example.springboot.entity.BookEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private BookDao bookRepo;

    public List<BookEntity> searchByKind(String kind) {
        List<BookEntity> list = bookRepo.queryByKind(kind);
        return list;
    }


    public List<BookEntity> searchByLanguage(String language) {
        List<BookEntity> list = bookRepo.queryByLanguage(language);
        return list;
    }


    public List<BookEntity> searchByPrice(double min, double max) {
        List<BookEntity> list = bookRepo.queryByPriceBetween(min, max);
        return list;
    }

    public String addOneBook(String bookname){
        List<BookEntity> list = bookRepo.queryByBookname(bookname);
        BookEntity book = list.get(0);
        if(book.getAmount() == 0) {
            System.out.println("size:"+list.size());
            return "Not enough";
        }
        else{
            System.out.println("size:"+list.size());
            return "Success";
        }

    }
}


   /* @Transactional
    public List<Book> searchByAuthor(String author){
        SessionFactory sessionfactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionfactory.openSession();
        Transaction transaction = session.beginTransaction();


        return Null;
    }

    @Transactional
    public List<Book> searchByPrice(String price){
        SessionFactory sessionfactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionfactory.openSession();
        Transaction transaction = session.beginTransaction();


    }

    @Transactional
    public List<Book> searchByYear(String year){
        SessionFactory sessionfactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionfactory.openSession();
        Transaction transaction = session.beginTransaction();

    }

}*/
