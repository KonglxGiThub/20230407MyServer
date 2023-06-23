package com.stu.myserver.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;

import com.stu.myserver.service.IUserService;
import com.stu.myserver.entity.User;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 用户表 前端控制器
 * </p>
 *
 * @author 程序员小明1024
 * @since 2023-06-23
 */
@RestController
@RequestMapping("/user")
    public class UserController {

    @Resource
    private IUserService userService;

    // 新增或者更新
    /***********************************
     * 用途说明:
     * @param user
     * 返回值说明:
     * @return boolean
     ***********************************/
    @PostMapping("/save")
    public boolean save(@RequestBody User user){
        return userService.saveOrUpdate(user);
    }

    /***********************************
     * 用途说明:
     * @param id
     * 返回值说明:
     * @return Boolean
     ***********************************/
    @DeleteMapping("/{id}")
    public Boolean delete(@PathVariable Integer id){
        return userService.removeById(id);
    }

    /***********************************
     * 用途说明:
     * @param ids
     * 返回值说明:
     * @return boolean
     ***********************************/
    @PostMapping("/del/batch")
    public boolean deleteBatch(@RequestBody List<Integer> ids){
        return userService.removeByIds(ids);
    }

    /***********************************
     * 用途说明:
     * @param:
     * 返回值说明:
     * @return List<User>
     ***********************************/
    @GetMapping
    public List<User> findAll(){
        return userService.list();
    }

    /***********************************
     * 用途说明:
     * @param id
     * 返回值说明:
     * @return User
     ***********************************/
    @GetMapping("/{id}")
    public User findOne(@PathVariable Integer id){
        return userService.getById(id);
    }

    /***********************************
     * 用途说明:
     * @param pageNum pageSize user
     * 返回值说明:
     * @return  Page<User>
     ***********************************/
    @PostMapping("/page")
    public Page<User> findPage(@RequestParam Integer pageNum,
                                    @RequestParam Integer pageSize,
                                    @RequestBody User user){
            QueryWrapper<User> queryWrapper=new QueryWrapper<>();
            queryWrapper.orderByDesc("id");
            return userService.page(new Page<>(pageNum,pageSize),queryWrapper);
        }
    }

