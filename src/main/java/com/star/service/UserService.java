package com.star.service;

import com.star.model.User;

/**
 * Created by zhangnan on 16/7/23.
 */
public interface UserService {
    boolean register(User user);

    User login(User user);

    User queryUserIsExist(User user);

    User queryUserByUserAndUUID(User user);
}
