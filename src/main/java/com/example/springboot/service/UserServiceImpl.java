package com.example.springboot.service;

import com.example.springboot.dao.UserDao;
import com.example.springboot.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Iterator;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userRepo;

    public String search(String name, String pwd)
    {
        UserEntity user = userRepo.findByUsername(name);
        if (user == null) {
            return "Fail";
        }
        //UserEntity user = list.get(0);
        if (user.getUserpassword().equals(pwd)){
            return "Success";
        }
        else{
            return "Password wrong";
        }
    }

    public UserEntity findUser(String name){
        UserEntity user = userRepo.findByUsername(name);
        return user;
    }


    public String add(String name, String pwd, String email, String addr, String phone)
    {
        UserEntity user = userRepo.findByUsername(name);
        //Iterator itr = list.iterator();
        if (user == null) {
            UserEntity singleUser = new UserEntity();
            singleUser.setUsername(name);
            singleUser.setUserpassword(pwd);
            singleUser.setUseremail(email);
            singleUser.setUseraddress(addr);
            singleUser.setUserphone(phone);
            userRepo.save(singleUser);
            return "Success";
        } else {
            return "Fail!";
        }

    }

}
