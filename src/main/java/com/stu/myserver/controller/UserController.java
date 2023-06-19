package com.stu.myserver.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.stu.myserver.entity.User;
import com.stu.myserver.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;
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

    /******************************
     * 用途说明: 
     * 作者姓名: 程序员小明1024
     * 创建时间: 2023-02-27
     ******************************/
    @GetMapping("/page")
    public Page<User> findPage(@RequestParam Integer pageNum,
                               @RequestParam Integer pageSize){
        QueryWrapper<User> queryWrapper=new QueryWrapper<>();
        queryWrapper.orderByDesc("create_time");
        return userService.page(new Page<>(pageNum,pageSize),queryWrapper);
    }


}

