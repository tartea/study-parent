package org.tartea.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.tartea.entity.User;
import org.tartea.mapper.UserMapper;
import org.tartea.service.UserService;

public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {


    public void queryAll(){
        this.query();
    }

}
