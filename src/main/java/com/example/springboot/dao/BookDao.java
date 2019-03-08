package com.example.springboot.dao;

import com.example.springboot.entity.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface BookDao extends JpaRepository<BookEntity, String>{

    @Query("select book from BookEntity book where book.kind = :kind")
    List<BookEntity> queryByKind(@Param("kind") String kind);

    @Query("select book from BookEntity book where book.language = :language")
    List<BookEntity> queryByLanguage(@Param("language") String language);

    @Query("select book from BookEntity book where book.price < :max and book.price >= :min")
    List<BookEntity> queryByPriceBetween(@Param("min") double min,
                                  @Param("max") double max);

    @Query("select book from BookEntity book where book.bookname = :bookname")
    List<BookEntity> queryByBookname(@Param("bookname") String bookname);

    @Transactional
    @Modifying
    @Query("update BookEntity book set book.amount = :newAmount where book.bookname = :bookname")
    int updateAmount(@Param("newAmount") int newAmount,@Param("bookname") String bookname);
}
