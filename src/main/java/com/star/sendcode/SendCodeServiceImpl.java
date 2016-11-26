package com.star.sendcode;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.star.dao.SendCodeDao;
import com.star.model.SendSMS;
import com.taobao.api.DefaultTaobaoClient;
import com.taobao.api.TaobaoClient;
import com.taobao.api.request.AlibabaAliqinFcSmsNumSendRequest;
import com.taobao.api.response.AlibabaAliqinFcSmsNumSendResponse;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by zhangnan on 16/11/24.
 */
@Service
public class SendCodeServiceImpl implements SendCodeService{

    @Resource
    private SendCodeDao sendCodeDao;

    @Override
    public String sendCode(Map<String,String> code, String mobile, String smsTemp,int smsType) {

        if (smsType==SMS_CODE_TO_REGISTER){
            //如果是短信验证码，查看短信在60秒内是否发送过，发送过的话就直接返回错误
            SendSMS sendSMS = sendCodeDao.querySendSMSUnUsed(mobile);
            if (sendSMS!=null){
                return "error";
            }
        }
        if (smsType==SendCodeService.SMS_CODE_TO_REGISTER){
            code=new HashMap<String, String>();
            //是请求注册短信，需要生成4位数字验证码
            int random=(int)(Math.random()*9000+1000);
            code.put("authCode",random+"");
        }

        //整理参数，发送短信
        ObjectMapper mapper = new ObjectMapper();
        TaobaoClient client = new DefaultTaobaoClient(url, appKey, secret);
        AlibabaAliqinFcSmsNumSendRequest req = new AlibabaAliqinFcSmsNumSendRequest();
        req.setSmsType("normal");
        req.setSmsFreeSignName("白水");
        req.setRecNum(mobile);
        req.setSmsTemplateCode(smsTemp);
        AlibabaAliqinFcSmsNumSendResponse rsp = null;




        try {
            String sendCode = mapper.writeValueAsString(code);
            //保存到数据库发送的短信
            SendSMS insertSMS=new SendSMS();
            insertSMS.setIsUsed(0);
            insertSMS.setMobile(mobile);
            insertSMS.setSendCode(sendCode);
            insertSMS.setSmsTemp(smsTemp);
            sendCodeDao.insertSendSMS(insertSMS);

            req.setSmsParamString(sendCode);
            rsp = client.execute(req);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(rsp.getBody());


        return rsp.getBody();
    }

    @Override
    public SendSMS querySendSMSForRegister(String mobile) {
        return sendCodeDao.querySendSMSForRegister(mobile);
    }

    @Override
    public void updateSMSToUsed(String sendCode) {
        sendCodeDao.updateSMSToUsed(sendCode);
    }


}
