package com.star.dao;

import com.star.model.SendSMS;

/**
 * Created by zhangnan on 16/11/24.
 */
public interface SendCodeDao {


    public SendSMS querySendSMSUnUsed(String mobile);

    public SendSMS querySendSMSForRegister(String mobile);

    public void insertSendSMS(SendSMS sendSMS);

    public void updateSMSToUsed(String sendCode);

}
