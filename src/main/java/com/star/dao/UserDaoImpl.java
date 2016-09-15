package com.star.dao;

import com.star.mapper.UserMapper;
import com.star.model.User;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * Created by zhangnan on 16/7/23.
 */
@Repository
public class UserDaoImpl implements UserDao{

    @Resource
    private UserMapper userMapper;


    @Override
    public void register(User user) {
        userMapper.register(user);
    }

    @Override
    public User login(User user) {
        return userMapper.login(user);
    }

    @Override
    public User queryUserIsExist(User user) {
        return userMapper.queryUserIsExist(user);
    }

    @Override
    public void setUserInfo(User user) {
        userMapper.setUserInfo(user);
    }

    @Override
    public User queryUserByUserAndUUID(User user) {
        return userMapper.queryUserByUserAndUUID(user);
    }

    @Override
    public void updateUserLastLoginTime(User user) {
        userMapper.updateUserLastLoginTime(user);
    }
}
