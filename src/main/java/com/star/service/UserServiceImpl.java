package com.star.service;

import com.star.dao.UserDao;
import com.star.model.User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.UUID;

/**
 * Created by zhangnan on 16/7/23.
 */
@Service
public class UserServiceImpl implements UserService{

    @Resource
    private UserDao userDao;

    @Override
    public boolean register(User user) {
        User userExist = queryUserIsExist(user);
        if (null!=userExist){
            return false;
        }
        user.setUuid(UUID.randomUUID().toString().replace("-", ""));
        userDao.register(user);
        return true;
    }

    @Override
    public User login(User user) {
        User loginUser = userDao.login(user);
        if (null!=loginUser){
            loginUser.setUuid(UUID.randomUUID().toString().replace("-", ""));
            userDao.setUserInfo(loginUser);
        }
        return loginUser;
    }

    @Override
    public User queryUserIsExist(User user) {
        return userDao.queryUserIsExist(user);
    }

    @Override
    public User queryUserByUserAndUUID(User user) {
        return userDao.queryUserByUserAndUUID(user);
    }

    @Override
    public void updateUserLastLoginTime(User user) {
        userDao.updateUserLastLoginTime(user);
    }


}
