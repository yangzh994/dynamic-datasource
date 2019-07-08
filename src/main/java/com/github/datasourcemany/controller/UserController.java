package com.github.datasourcemany.controller;


import com.github.datasourcemany.model.User;
import com.github.datasourcemany.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/user1")
    @ResponseBody
    public String addUser1(){
        User user = new User();
        user.setName("user1");
        userService.addUser(user);
        return "SUCCESS";
    }

    @RequestMapping("/user2")
    @ResponseBody
    public String addUser2(){
        User user = new User();
        user.setName("user2");
        userService.addUser(user);
        return "SUCCESS";
    }
}
