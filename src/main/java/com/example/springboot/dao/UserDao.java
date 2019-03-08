package com.example.springboot.dao;

import com.example.springboot.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDao extends JpaRepository<UserEntity, String> {

   @Query("select user from UserEntity user where user.username = :username")
   List<UserEntity> queryByUsername(@Param("username") String username);

    <S extends UserEntity> S save (S singleuser);
    UserEntity findByUsername(String username);
}