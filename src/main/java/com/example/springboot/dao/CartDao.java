package com.example.springboot.dao;

import com.example.springboot.entity.BookEntity;
import com.example.springboot.entity.CartEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface CartDao extends JpaRepository<CartEntity, String>{


    @Query("select book from CartEntity book where book.username = :username")
    List<CartEntity> queryByUsername(@Param("username") String username);

    @Transactional
    <S extends CartEntity> S save (S cartrow);
}
