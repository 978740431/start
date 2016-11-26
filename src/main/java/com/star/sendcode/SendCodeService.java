package com.star.sendcode;

import com.star.model.SendSMS;

import java.util.Map;

/**
 * Created by zhangnan on 16/11/24.
 */
public interface SendCodeService {


    String url="http://gw.api.taobao.com/router/rest";
    String appKey="23546441";
    String secret="7cc84b26e44d5b0135bcda17b2bc38d9";

    public static int SMS_CODE_TO_REGISTER=1;


    public String sendCode(Map<String,String> code,String mobile,String smsTemp,int smsType);


    public SendSMS querySendSMSForRegister(String mobile);
    public void updateSMSToUsed(String sendCode);



}
