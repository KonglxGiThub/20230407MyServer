package com.stu.myserver.service.impl;

import com.stu.myserver.entity.User;
import com.stu.myserver.mapper.UserMapper;
import com.stu.myserver.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 公众号:程序员小明1024
 * @since 2023-06-14
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}
