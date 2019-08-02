package com.fish.controller;

import com.fish.dao.UserDao;
import com.fish.model.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserDao userDao;


    @RequestMapping("getAllUsers")
    @ResponseBody
    public List<UserModel> getAllUsers() {
        List<UserModel> userModels = userDao.getAllUsers();
        return userModels;
    }
}