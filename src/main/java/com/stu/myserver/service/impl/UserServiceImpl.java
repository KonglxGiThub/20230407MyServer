package com.stu.myserver.service.impl;

import com.stu.myserver.entity.User;
import com.stu.myserver.mapper.UserMapper;
import com.stu.myserver.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author 程序员小明1024
 * @since 2023-06-23
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

}
