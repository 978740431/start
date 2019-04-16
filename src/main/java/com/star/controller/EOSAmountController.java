package com.star.controller;

import com.google.gson.Gson;
import com.star.common.RedisService;
import com.star.mapper.CoinCountTimeMapper;
import com.star.mapper.EthAmountMapper;
import com.star.model.btc.BtcAmount;
import com.star.model.btc.BtcAmountQuery;
import com.star.model.btc.EthAmount;
import com.star.model.btc.EthAmountQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by admin on 2016/6/18.
 */

@Controller
@RequestMapping("/eos_amount")
public class EOSAmountController {

    @Autowired
    private CoinCountTimeMapper coinCountTimeMapper;

    @ResponseBody
    @RequestMapping(value = "/eos_list_10", method = RequestMethod.GET)
    public String eos10Top() {

        //返回的list
        List<Object> resultList = new ArrayList<Object>();

        BtcAmountQuery btcAmountQuery = new BtcAmountQuery();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");

        //eth 前2400
        btcAmountQuery.setCoinType("eos");
        btcAmountQuery.setDataType(61);
        List<BtcAmount> eosAmount10List = coinCountTimeMapper.queryTopList(btcAmountQuery);
        List<String> eosCreateTime10List = new ArrayList<String>();
        List<Long> eosCount10List = new ArrayList<Long>();
        for (BtcAmount btcAmount : eosAmount10List) {
            eosCreateTime10List.add(format.format(btcAmount.getCreateTime()));
            eosCount10List.add(btcAmount.getBtcCount());
        }
        resultList.add(eosCreateTime10List);
        resultList.add(eosCount10List);
        return new Gson().toJson(resultList);
    }

    @ResponseBody
    @RequestMapping(value = "/eos_list_30", method = RequestMethod.GET)
    public String eos30Top() {

        //返回的list
        List<Object> resultList = new ArrayList<Object>();

        BtcAmountQuery btcAmountQuery = new BtcAmountQuery();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");

        //eth 前2400
        btcAmountQuery.setCoinType("eos");
        btcAmountQuery.setDataType(62);
        List<BtcAmount> eosAmount10List = coinCountTimeMapper.queryTopList(btcAmountQuery);
        List<String> eosCreateTime10List = new ArrayList<String>();
        List<Long> eosCount10List = new ArrayList<Long>();
        for (BtcAmount btcAmount : eosAmount10List) {
            eosCreateTime10List.add(format.format(btcAmount.getCreateTime()));
            eosCount10List.add(btcAmount.getBtcCount());
        }
        resultList.add(eosCreateTime10List);
        resultList.add(eosCount10List);
        return new Gson().toJson(resultList);
    }

    @ResponseBody
    @RequestMapping(value = "/eos_list_100", method = RequestMethod.GET)
    public String eos100Top() {

        //返回的list
        List<Object> resultList = new ArrayList<Object>();

        BtcAmountQuery btcAmountQuery = new BtcAmountQuery();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");

        //eth 前2400
        btcAmountQuery.setCoinType("eos");
        btcAmountQuery.setDataType(63);
        List<BtcAmount> eosAmount10List = coinCountTimeMapper.queryTopList(btcAmountQuery);
        List<String> eosCreateTime10List = new ArrayList<String>();
        List<Long> eosCount10List = new ArrayList<Long>();
        for (BtcAmount btcAmount : eosAmount10List) {
            eosCreateTime10List.add(format.format(btcAmount.getCreateTime()));
            eosCount10List.add(btcAmount.getBtcCount());
        }
        resultList.add(eosCreateTime10List);
        resultList.add(eosCount10List);
        return new Gson().toJson(resultList);
    }

    @ResponseBody
    @RequestMapping(value = "/eos_list_500", method = RequestMethod.GET)
    public String eos500Top() {

        //返回的list
        List<Object> resultList = new ArrayList<Object>();

        BtcAmountQuery btcAmountQuery = new BtcAmountQuery();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");

        //eth 前2400
        btcAmountQuery.setCoinType("eos");
        btcAmountQuery.setDataType(64);
        List<BtcAmount> eosAmount10List = coinCountTimeMapper.queryTopList(btcAmountQuery);
        List<String> eosCreateTime10List = new ArrayList<String>();
        List<Long> eosCount10List = new ArrayList<Long>();
        for (BtcAmount btcAmount : eosAmount10List) {
            eosCreateTime10List.add(format.format(btcAmount.getCreateTime()));
            eosCount10List.add(btcAmount.getBtcCount());
        }
        resultList.add(eosCreateTime10List);
        resultList.add(eosCount10List);
        return new Gson().toJson(resultList);
    }


}
