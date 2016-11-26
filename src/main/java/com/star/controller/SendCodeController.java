package com.star.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.star.model.CommonResult;
import com.star.sendcode.SendCodeService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * Created by zhangnan on 16/11/24.
 */
@Controller
public class SendCodeController {


    @Resource
    private SendCodeService sendCodeService;

    @ResponseBody
    @RequestMapping(value = "/sendSMSCode",method = RequestMethod.GET)
    public String sendSMSCode(String mobile){
//        String sendCode =null;
        String result = sendCodeService.sendCode(null, mobile, "SMS_29435018", SendCodeService.SMS_CODE_TO_REGISTER);

        /*ObjectMapper mapper = new ObjectMapper();
        try {
            CommonResult commonResult=new CommonResult();
            commonResult.setResultKey("result");
            commonResult.setResultValue("0");
            sendCode = mapper.writeValueAsString(commonResult);
        } catch (JsonProcessingException e) {

            e.printStackTrace();
        }*/
        return result;
    }
}
