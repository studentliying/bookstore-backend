package com.example.springboot.controller;
import com.example.springboot.entity.UserEntity;
import com.example.springboot.service.UserService;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@RestController
@RequestMapping(value="/User")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping(value="/logon")
    private String processlLogon(@RequestParam("name") String name,
                                 @RequestParam("pwd") String pwd,
                                 HttpServletResponse response, HttpSession session) {

        String check = userService.search(name, pwd);
        if (!check.equals("Success")) {
            return check;
        } else {
            UserEntity user = userService.findUser(name);
            System.out.println("sessionid1:"+session.getId());
            session.setAttribute("user", user);
            System.out.println(((UserEntity)session.getAttribute("user")).getUsername());
            return name;
        }
    }

    @RequestMapping(value="login")
    private String processLogin(@RequestParam("name") String name,
                              @RequestParam("pwd") String pwd,
                              @RequestParam("email") String email,
                              @RequestParam("addr") String addr,
                              @RequestParam("phone") String phone,
                              HttpServletResponse response, HttpSession session)
    {
        return userService.add(name, pwd, email, addr, phone);
    }

    @RequestMapping(value="/showAddress",method = RequestMethod.POST)
    private UserEntity processLogin(HttpServletResponse response, HttpSession session)
    {
        String username="";
        if (session.getAttribute("user")!=null) {
            username = (((UserEntity) session.getAttribute("user")).getUsername());
        }
        return (UserEntity) session.getAttribute("user");
    }

}
