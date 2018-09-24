package com.star.controller;

import com.google.gson.Gson;
import com.star.mapper.CoinCountTimeMapper;
import com.star.model.btc.BtcAmount;
import com.star.model.btc.BtcAmountQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by admin on 2016/6/18.
 */

@Controller
@RequestMapping("/dash_amount")
public class DashAmountController {


    @Autowired
    private CoinCountTimeMapper coinCountTimeMapper;
    /**
     * bch前500持仓列表
     *
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/dash_top_list", method = RequestMethod.GET)
    public String bchTopList() {

        //返回的list
        List<Object> resultList = new ArrayList<Object>();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");


        //dash 前10
        BtcAmountQuery btcAmountQuery = new BtcAmountQuery();
        btcAmountQuery.setCoinType("dash");
        btcAmountQuery.setDataType(34);
        List<BtcAmount> btcAmount10List = coinCountTimeMapper.queryTopList(btcAmountQuery);
        List<String> btcCreateTime10List = new ArrayList<String>();
        List<Long> btcCount10List = new ArrayList<Long>();
        for (BtcAmount btcAmount : btcAmount10List) {
            btcCreateTime10List.add(format.format(btcAmount.getCreateTime()));
            btcCount10List.add(btcAmount.getBtcCount());
        }
        resultList.add(btcCreateTime10List);
        resultList.add(btcCount10List);

        //dash 前100
        btcAmountQuery.setDataType(32);
        btcAmountQuery.setCoinType("dash");
        List<BtcAmount> btcAmount100List = coinCountTimeMapper.queryTopList(btcAmountQuery);
        List<String> createTime100List = new ArrayList<String>();
        List<Long> btcCount100List = new ArrayList<Long>();
        for (BtcAmount btcAmount : btcAmount100List) {
            createTime100List.add(format.format(btcAmount.getCreateTime()));
            btcCount100List.add(btcAmount.getBtcCount());
        }
        resultList.add(createTime100List);
        resultList.add(btcCount100List);


        //dash 前500
        btcAmountQuery.setCoinType("dash");
        btcAmountQuery.setDataType(30);
        List<BtcAmount> btcAmountList = coinCountTimeMapper.queryTopList(btcAmountQuery);

        List<String> createTimeList = new ArrayList<String>();
        List<Long> btcCountList = new ArrayList<Long>();
        for (BtcAmount btcAmount : btcAmountList) {
            createTimeList.add(format.format(btcAmount.getCreateTime()));
            btcCountList.add(btcAmount.getBtcCount());
        }
        resultList.add(createTimeList);
        resultList.add(btcCountList);

        //dash 前1000
        btcAmountQuery.setDataType(33);
        btcAmountQuery.setCoinType("dash");
        List<BtcAmount> btcAmount1000List = coinCountTimeMapper.queryTopList(btcAmountQuery);
        List<String> createTime1000List = new ArrayList<String>();
        List<Long> btcCount1000List = new ArrayList<Long>();
        for (BtcAmount btcAmount : btcAmount1000List) {
            createTime1000List.add(format.format(btcAmount.getCreateTime()));
            btcCount1000List.add(btcAmount.getBtcCount());
        }
        resultList.add(createTime1000List);
        resultList.add(btcCount1000List);


        //dash 前1500
        btcAmountQuery.setCoinType("dash");
        btcAmountQuery.setDataType(31);
        List<BtcAmount> btcAmount1500List = coinCountTimeMapper.queryTopList(btcAmountQuery);

        List<String> createTime1500List = new ArrayList<String>();
        List<Long> btcCount1500List = new ArrayList<Long>();
        for (BtcAmount btcAmount : btcAmount1500List) {
            createTime1500List.add(format.format(btcAmount.getCreateTime()));
            btcCount1500List.add(btcAmount.getBtcCount());
        }
        resultList.add(createTime1500List);
        resultList.add(btcCount1500List);


        return new Gson().toJson(resultList);
    }

}
