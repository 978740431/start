package com.star.dao;

import com.star.model.User;

/**
 * Created by zhangnan on 16/7/23.
 */
public interface UserDao {
    void register(User user);

    User login(User user);

    User queryUserIsExist(User user);

    void setUserInfo(User user);

    User queryUserByUserAndUUID(User user);

    void updateUserLastLoginTime(User user);

}
