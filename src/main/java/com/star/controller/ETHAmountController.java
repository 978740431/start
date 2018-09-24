package com.star.controller;

import com.google.gson.Gson;
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
@RequestMapping("/eth_amount")
public class ETHAmountController {

    @Autowired
    private CoinCountTimeMapper coinCountTimeMapper;

    /**
     * btc前500持仓列表
     *
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/eth_top_list", method = RequestMethod.GET)
    public String btcTopList() {

        //返回的list
        List<Object> resultList = new ArrayList<Object>();

        BtcAmountQuery btcAmountQuery = new BtcAmountQuery();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");


        //eth 前10
        btcAmountQuery.setCoinType("eth");
        btcAmountQuery.setDataType(10);
        List<BtcAmount> ethAmount10List = coinCountTimeMapper.queryTopList(btcAmountQuery);
        List<String> ethCreateTime10List = new ArrayList<String>();
        List<Long> ethCount10List = new ArrayList<Long>();
        for (BtcAmount btcAmount : ethAmount10List) {
            ethCreateTime10List.add(format.format(btcAmount.getCreateTime()));
            ethCount10List.add(btcAmount.getBtcCount());
        }
        resultList.add(ethCreateTime10List);
        resultList.add(ethCount10List);

        //eth 前100
        btcAmountQuery.setCoinType("eth");
        btcAmountQuery.setDataType(9);
        List<BtcAmount> ethAmount100List = coinCountTimeMapper.queryTopList(btcAmountQuery);
        List<String> ethCreateTime100List = new ArrayList<String>();
        List<Long> ethCount100List = new ArrayList<Long>();
        for (BtcAmount btcAmount : ethAmount100List) {
            ethCreateTime100List.add(format.format(btcAmount.getCreateTime()));
            ethCount100List.add(btcAmount.getBtcCount());
        }
        resultList.add(ethCreateTime100List);
        resultList.add(ethCount100List);


        //eth 前500
        btcAmountQuery.setCoinType("eth");
        btcAmountQuery.setDataType(1);
        List<BtcAmount> ethAmountList = coinCountTimeMapper.queryTopList(btcAmountQuery);
        List<String> ethCreateTimeList = new ArrayList<String>();
        List<Long> ethCountList = new ArrayList<Long>();
        for (BtcAmount btcAmount : ethAmountList) {
            ethCreateTimeList.add(format.format(btcAmount.getCreateTime()));
            ethCountList.add(btcAmount.getBtcCount());
        }
        resultList.add(ethCreateTimeList);
        resultList.add(ethCountList);


        //eth 前1500
        btcAmountQuery.setCoinType("eth");
        btcAmountQuery.setDataType(2);
        List<BtcAmount> ethAmount1500List = coinCountTimeMapper.queryTopList(btcAmountQuery);
        List<String> ethCreateTime1500List = new ArrayList<String>();
        List<Long> ethCount1500List = new ArrayList<Long>();
        for (BtcAmount btcAmount : ethAmount1500List) {
            ethCreateTime1500List.add(format.format(btcAmount.getCreateTime()));
            ethCount1500List.add(btcAmount.getBtcCount());
        }
        resultList.add(ethCreateTime1500List);
        resultList.add(ethCount1500List);

        //eth 前2400
        btcAmountQuery.setCoinType("eth");
        btcAmountQuery.setDataType(8);
        List<BtcAmount> ethAmount2400List = coinCountTimeMapper.queryTopList(btcAmountQuery);
        List<String> ethCreateTime2400List = new ArrayList<String>();
        List<Long> ethCount2400List = new ArrayList<Long>();
        for (BtcAmount btcAmount : ethAmount2400List) {
            ethCreateTime2400List.add(format.format(btcAmount.getCreateTime()));
            ethCount2400List.add(btcAmount.getBtcCount());
        }
        resultList.add(ethCreateTime2400List);
        resultList.add(ethCount2400List);

        return new Gson().toJson(resultList);
    }


    @Resource
    private EthAmountMapper ethAmountMapper;


    @ResponseBody
    @RequestMapping(value = "/query_eth_address", method = RequestMethod.GET)
    public String queryEthAddress() {

        List<Object> resultList = new ArrayList<Object>();

        List<EthAmount> createTimeCountList = ethAmountMapper.queryCount(null);

        EthAmountQuery ethAmountQuery = new EthAmountQuery();
        ethAmountQuery.setEthAddress("0x742d35cc6634c0532925a3b844bc454e4438f44e");
        List<EthAmount> ethAmountList = ethAmountMapper.queryList(ethAmountQuery);

        ethAmountQuery.setEthAddress("0xfe9e8709d3215310075d67e3ed32a380ccf451c8");
        List<EthAmount> ethAmountBinanceList = ethAmountMapper.queryList(ethAmountQuery);

        ethAmountQuery.setEthAddress("0xe853c56864a2ebe4576a807d26fdc4a0ada51919");
        List<EthAmount> ethAmountKrakenList = ethAmountMapper.queryList(ethAmountQuery);

        ethAmountQuery.setEthAddress("0xdc76cd25977e0a5ae17155770273ad58648900d3");
        List<EthAmount> ethAmountHuobiList = ethAmountMapper.queryList(ethAmountQuery);


        List<String> createTimeList = new ArrayList<String>();

        int count = createTimeCountList.size();

        List<Long> countList = new ArrayList<Long>(count);
        List<Long> countBinanceList = new ArrayList<Long>(count);
        List<Long> countKrakenList = new ArrayList<Long>(count);
        List<Long> countHuobiList = new ArrayList<Long>(count);

        for (int i = 0; i < count; i++) {
            countList.add(null);
            countBinanceList.add(null);
            countKrakenList.add(null);
            countHuobiList.add(null);
        }

        for (EthAmount ethAmount : createTimeCountList) {
            createTimeList.add(ethAmount.getCreateTime());
        }
        resultList.add(createTimeList);

        int index = 1;
        for (int i = ethAmountList.size() - 1; i >= 0; i--) {
            EthAmount ethAmount = ethAmountList.get(i);
            countList.set(count - index, ethAmount.getEthCount());
            index++;
        }
        resultList.add(countList);

        index = 1;
        for (int i = ethAmountBinanceList.size() - 1; i >= 0; i--) {
            EthAmount ethAmount = ethAmountBinanceList.get(i);
            countBinanceList.set(count - index, ethAmount.getEthCount());
            index++;
        }
        resultList.add(countBinanceList);

        index = 1;
        for (int i = ethAmountKrakenList.size() - 1; i >= 0; i--) {
            EthAmount ethAmount = ethAmountKrakenList.get(i);
            countKrakenList.set(count - index, ethAmount.getEthCount());
            index++;
        }
        resultList.add(countKrakenList);

        index = 1;
        for (int i = ethAmountHuobiList.size() - 1; i >= 0; i--) {
            EthAmount ethAmount = ethAmountHuobiList.get(i);
            countHuobiList.set(count - index, ethAmount.getEthCount());
            index++;
        }
        resultList.add(countHuobiList);


        String ethAmount = new Gson().toJson(resultList);

        return ethAmount;

    }


}
