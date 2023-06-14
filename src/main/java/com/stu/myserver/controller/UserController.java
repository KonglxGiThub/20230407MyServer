package com.stu.myserver.controller;


import com.stu.myserver.entity.User;
import com.stu.myserver.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author 公众号:程序员小明1024
 * @since 2023-06-14
 */
@RestController
@RequestMapping("/myserver/user")
public class UserController {

    @Autowired
    private UserService userService;


    @GetMapping
    public List<User> index(){
        List<User> list = userService.list();
        return list;
    }
}

