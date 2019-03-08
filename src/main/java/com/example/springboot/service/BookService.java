package com.example.springboot.service;

import com.example.springboot.entity.BookEntity;
import java.util.List;

public interface BookService {

    List<BookEntity> searchByKind(String kind);

    List<BookEntity> searchByLanguage(String language);

    List<BookEntity> searchByPrice(double min, double max);

    String addOneBook(String bookname);

}

   /* List<Book> searchByYear(String year);
}*/
