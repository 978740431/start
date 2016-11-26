package com.star.service;

import com.star.dao.UserDao;
import com.star.model.CommonResult;
import com.star.model.SendSMS;
import com.star.model.User;
import com.star.sendcode.SendCodeService;
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

    @Resource
    private SendCodeService sendCodeService;


    @Override
    public CommonResult register(User user) {
        CommonResult commonResult=new CommonResult();

        SendSMS sendSMS = sendCodeService.querySendSMSForRegister(user.getUsername());
        if (sendSMS==null || !sendSMS.getSendCode().contains(user.getAuthCode())){
            commonResult.setResultValue("验证码不正确");
            commonResult.setResultKey("105");
            return commonResult;
        }

        User userExist = queryUserIsExist(user);
        if (null!=userExist){
            commonResult.setResultValue("用户已存在");
            commonResult.setResultKey("105");
            return commonResult;
        }
        user.setUuid(UUID.randomUUID().toString().replace("-", ""));
        userDao.register(user);
        sendCodeService.updateSMSToUsed(user.getAuthCode());
        commonResult.setResultKey("0");
        return commonResult;
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
