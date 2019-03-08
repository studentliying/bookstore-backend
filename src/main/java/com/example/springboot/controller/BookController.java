package com.example.springboot.controller;


import com.example.springboot.entity.BookEntity;
import com.example.springboot.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequestMapping(value="/Book")
public class BookController {
    @Autowired
    private BookService bookService;

    @RequestMapping(value = "/searchByKind")
    private List<BookEntity> processSearchByKind(@RequestParam("kind") String kind,
                                                 HttpServletResponse response, HttpSession session)
    {
        return bookService.searchByKind(kind);
    }

    @RequestMapping(value = "/searchByLanguage")
    private List<BookEntity> processSearchByAuthor(@RequestParam("language") String language,
                                                   HttpServletResponse response, HttpSession session)
    {
        return bookService.searchByLanguage(language);
    }


    @RequestMapping(value="/searchByPrice")
    private List<BookEntity> processSearchByPrice(@RequestParam("min") double min,
                                                  @RequestParam("max") double max,
                                                  HttpServletResponse response, HttpSession session)
    {
        System.out.println("min:"+min);
        return bookService.searchByPrice(min, max);
    }

   @RequestMapping(value = "/addOneBook")
   private String processAddOneBook(@RequestParam("bookname") String bookname,
                                                  HttpServletResponse response, HttpSession session)
   {
       return bookService.addOneBook(bookname);
   }

}

    /*@RequestMapping(value="/searchByYear")
    private List<Book> processSearchByYear(@RequestParam("year") String year,
                                             HttpServletResponse response, HttpSession session)
    {
        List<Book> result =  bookService.searchByYear(year);
        return result;
    }
}
*/