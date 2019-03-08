package com.example.springboot.dao;

import com.example.springboot.entity.BookEntity;
import com.example.springboot.entity.CartEntity;
import com.example.springboot.entity.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface OrderDao extends JpaRepository<OrderEntity, Integer> {
    @Query("select order from OrderEntity order where order.username = :username")
    List<OrderEntity> queryByUsername(@Param("username") String username);
}
