package com.star.dao;

import com.star.mapper.SendSMSMapper;
import com.star.model.SendSMS;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * Created by zhangnan on 16/11/24.
 */
@Repository("sendCode")
public class SendCodeDaoImpl implements SendCodeDao{

    @Resource
    private SendSMSMapper sendSMSMapper;

    public SendSMS querySendSMSUnUsed(String mobile){
        return sendSMSMapper.querySendSMSUnUsed(mobile);
    }

    public SendSMS querySendSMSForRegister(String mobile){
        return sendSMSMapper.querySendSMSForRegister(mobile);
    }

    public void insertSendSMS(SendSMS sendSMS){
        sendSMSMapper.insertSendSMS(sendSMS);
    }
    public void updateSMSToUsed(String sendSMS){
        sendSMSMapper.updateSMSToUsed(sendSMS);
    }

}
