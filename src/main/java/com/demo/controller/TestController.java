package com.demo.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.demo.entity.User;
import com.demo.service.serviceImp.UserServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class TestController extends baseController{

    @Autowired
    private UserServiceImp userServiceImp;

    @RequestMapping(value = "/hello",method = RequestMethod.GET)
    public String hello(){
        return "hello word";
    }

    @RequestMapping(value = "/getUserInfo",method = RequestMethod.GET)
    public User getUserInfo(){
        User userInfo = userServiceImp.getUserInfo();
        return userInfo;
    }

    @RequestMapping(value = "addUser",method = RequestMethod.GET)
    public void addUser(){
        userServiceImp.addUser();
    }

    /**
     * 分页查询
     * @return
     */
    @RequestMapping(value = "pageUser",method = RequestMethod.GET)
    public Page<User> userList(){
        Page<User> page = new Page<>();
        page.setSize(1);
        return  userServiceImp.selectUserPage(page);
    }
}
