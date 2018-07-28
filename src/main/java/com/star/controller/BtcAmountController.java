package com.star.controller;

import com.google.gson.Gson;
import com.star.mapper.CoinCountTimeMapper;
import com.star.mapper.ICOTokenMapper;
import com.star.model.btc.*;
import com.star.service.btc.BtcAmountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by admin on 2016/6/18.
 */

@Controller
@RequestMapping("/btc_amount")
public class BtcAmountController {


    @Autowired
    private BtcAmountService btcAmountService;

    @Autowired
    private CoinCountTimeMapper coinCountTimeMapper;

    @Autowired
    private ICOTokenMapper icoTokenMapper;

    /**
     * 文章列表
     *
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/btc_amount_list", method = RequestMethod.GET)
    public String index() {
        List<BtcAmount> btcAmountList = btcAmountService.queryBtcAmountList();

        String json = new Gson().toJson(btcAmountList);
        return json;
    }

    /**
     * btc前500持仓列表
     *
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/btc_top_list", method = RequestMethod.GET)
    public String btcTopList() {

        //返回的list
        List<Object> resultList = new ArrayList<Object>();

        //btc 前500
        BtcAmountQuery btcAmountQuery = new BtcAmountQuery();
        btcAmountQuery.setCoinType("btc");
        btcAmountQuery.setDataType(1);
        List<BtcAmount> btcAmountList = coinCountTimeMapper.queryTopList(btcAmountQuery);

        List<String> createTimeList = new ArrayList<String>();
        List<Long> btcCountList = new ArrayList<Long>();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        for (BtcAmount btcAmount : btcAmountList) {
            createTimeList.add(format.format(btcAmount.getCreateTime()));
            btcCountList.add(btcAmount.getBtcCount());
        }
        resultList.add(createTimeList);
        resultList.add(btcCountList);

        //eth 前500
        btcAmountQuery.setCoinType("eth");
        List<BtcAmount> ethAmountList = coinCountTimeMapper.queryTopList(btcAmountQuery);
        List<String> ethCreateTimeList = new ArrayList<String>();
        List<Long> ethCountList = new ArrayList<Long>();
        for (BtcAmount btcAmount : ethAmountList) {
            ethCreateTimeList.add(format.format(btcAmount.getCreateTime()));
            ethCountList.add(btcAmount.getBtcCount());
        }
        resultList.add(ethCreateTimeList);
        resultList.add(ethCountList);


        //btc 前1500
        btcAmountQuery.setCoinType("btc");
        btcAmountQuery.setDataType(2);
        List<BtcAmount> btcAmount1500List = coinCountTimeMapper.queryTopList(btcAmountQuery);

        List<String> createTime1500List = new ArrayList<String>();
        List<Long> btcCount1500List = new ArrayList<Long>();
        for (BtcAmount btcAmount : btcAmount1500List) {
            createTime1500List.add(format.format(btcAmount.getCreateTime()));
            btcCount1500List.add(btcAmount.getBtcCount());
        }
        resultList.add(createTime1500List);
        resultList.add(btcCount1500List);


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


        //btc 前100
        btcAmountQuery.setDataType(6);
        btcAmountQuery.setCoinType("btc");
        List<BtcAmount> btcAmount100List = coinCountTimeMapper.queryTopList(btcAmountQuery);
        List<String> createTime100List = new ArrayList<String>();
        List<Long> btcCount100List = new ArrayList<Long>();
        for (BtcAmount btcAmount : btcAmount100List) {
            createTime100List.add(format.format(btcAmount.getCreateTime()));
            btcCount100List.add(btcAmount.getBtcCount());
        }
        resultList.add(createTime100List);
        resultList.add(btcCount100List);

        //btc 前1000
        btcAmountQuery.setDataType(7);
        btcAmountQuery.setCoinType("btc");
        List<BtcAmount> btcAmount1000List = coinCountTimeMapper.queryTopList(btcAmountQuery);
        List<String> createTime1000List = new ArrayList<String>();
        List<Long> btcCount1000List = new ArrayList<Long>();
        for (BtcAmount btcAmount : btcAmount1000List) {
            createTime1000List.add(format.format(btcAmount.getCreateTime()));
            btcCount1000List.add(btcAmount.getBtcCount());
        }
        resultList.add(createTime1000List);
        resultList.add(btcCount1000List);


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

        //btc 前10
        btcAmountQuery.setCoinType("btc");
        btcAmountQuery.setDataType(10);
        List<BtcAmount> btcAmount10List = coinCountTimeMapper.queryTopList(btcAmountQuery);
        List<String> btcCreateTime10List = new ArrayList<String>();
        List<Long> btcCount10List = new ArrayList<Long>();
        for (BtcAmount btcAmount : btcAmount10List) {
            btcCreateTime10List.add(format.format(btcAmount.getCreateTime()));
            btcCount10List.add(btcAmount.getBtcCount());
        }
        resultList.add(btcCreateTime10List);
        resultList.add(btcCount10List);

        //btc 前10
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


        return new Gson().toJson(resultList);
    }


    /**
     * 山寨币前100持仓列表
     *
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/token_top_list", method = RequestMethod.GET)
    public String tokenTopList() {


        //返回的list
        List<Object> resultList = new ArrayList<Object>();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");

        //iost
        BtcAmountQuery btcAmountQuery = new BtcAmountQuery();
        btcAmountQuery.setCoinType("iost");
        btcAmountQuery.setDataType(3);
        List<BtcAmount> btcAmountList = coinCountTimeMapper.queryTopList(btcAmountQuery);
        List<String> createTimeList = new ArrayList<String>();
        List<Long> btcCountList = new ArrayList<Long>();
        for (BtcAmount btcAmount : btcAmountList) {
            createTimeList.add(format.format(btcAmount.getCreateTime()));
            btcCountList.add(btcAmount.getBtcCount());
        }
        resultList.add(createTimeList);
        resultList.add(btcCountList);

        //zil
        btcAmountQuery.setCoinType("zil");
        List<BtcAmount> ethAmountList = coinCountTimeMapper.queryTopList(btcAmountQuery);
        List<String> ethCreateTimeList = new ArrayList<String>();
        List<Long> ethCountList = new ArrayList<Long>();
        for (BtcAmount btcAmount : ethAmountList) {
            ethCreateTimeList.add(format.format(btcAmount.getCreateTime()));
            ethCountList.add(btcAmount.getBtcCount());
        }
        resultList.add(ethCreateTimeList);
        resultList.add(ethCountList);


        //PAI
        btcAmountQuery.setCoinType("pai");
        List<BtcAmount> btcAmount1500List = coinCountTimeMapper.queryTopList(btcAmountQuery);
        List<String> createTime1500List = new ArrayList<String>();
        List<Long> btcCount1500List = new ArrayList<Long>();
        for (BtcAmount btcAmount : btcAmount1500List) {
            createTime1500List.add(format.format(btcAmount.getCreateTime()));
            btcCount1500List.add(btcAmount.getBtcCount());
        }
        resultList.add(createTime1500List);
        resultList.add(btcCount1500List);

        //HT
        btcAmountQuery.setCoinType("HT");
        List<BtcAmount> ht100List = coinCountTimeMapper.queryTopList(btcAmountQuery);
        List<String> createTimeHT100List = new ArrayList<String>();
        List<Long> htCount100List = new ArrayList<Long>();
        for (BtcAmount btcAmount : ht100List) {
            createTimeHT100List.add(format.format(btcAmount.getCreateTime()));
            htCount100List.add(btcAmount.getBtcCount());
        }
        resultList.add(createTimeHT100List);
        resultList.add(htCount100List);

        //ELF
        btcAmountQuery.setCoinType("ELF");
        List<BtcAmount> elf100List = coinCountTimeMapper.queryTopList(btcAmountQuery);
        List<String> createTimeELF100List = new ArrayList<String>();
        List<Long> elfCount100List = new ArrayList<Long>();
        for (BtcAmount btcAmount : elf100List) {
            createTimeELF100List.add(format.format(btcAmount.getCreateTime()));
            elfCount100List.add(btcAmount.getBtcCount());
        }
        resultList.add(createTimeELF100List);
        resultList.add(elfCount100List);

        //cmt
        btcAmountQuery.setCoinType("cmt");
        List<BtcAmount> cmt100List = coinCountTimeMapper.queryTopList(btcAmountQuery);
        List<String> createTimecmt100List = new ArrayList<String>();
        List<Long> cmtCount100List = new ArrayList<Long>();
        for (BtcAmount btcAmount : cmt100List) {
            createTimecmt100List.add(format.format(btcAmount.getCreateTime()));
            cmtCount100List.add(btcAmount.getBtcCount());
        }
        resultList.add(createTimecmt100List);
        resultList.add(cmtCount100List);

        //ctxc
        btcAmountQuery.setCoinType("ctxc");
        List<BtcAmount> ctxc100List = coinCountTimeMapper.queryTopList(btcAmountQuery);
        List<String> createTimectxc100List = new ArrayList<String>();
        List<Long> ctxcCount100List = new ArrayList<Long>();
        for (BtcAmount btcAmount : ctxc100List) {
            createTimectxc100List.add(format.format(btcAmount.getCreateTime()));
            ctxcCount100List.add(btcAmount.getBtcCount());
        }
        resultList.add(createTimectxc100List);
        resultList.add(ctxcCount100List);

        //bnb
        btcAmountQuery.setCoinType("bnb");
        List<BtcAmount> bnb100List = coinCountTimeMapper.queryTopList(btcAmountQuery);
        List<String> createTimebnb100List = new ArrayList<String>();
        List<Long> bnbCount100List = new ArrayList<Long>();
        for (BtcAmount btcAmount : bnb100List) {
            createTimebnb100List.add(format.format(btcAmount.getCreateTime()));
            bnbCount100List.add(btcAmount.getBtcCount());
        }
        resultList.add(createTimebnb100List);
        resultList.add(bnbCount100List);

        //dta前100
        btcAmountQuery.setCoinType("dta");
        btcAmountQuery.setDataType(3);
        List<BtcAmount> dta100List = coinCountTimeMapper.queryTopList(btcAmountQuery);
        List<String> createTimedta100List = new ArrayList<String>();
        List<Long> dtaCount100List = new ArrayList<Long>();
        for (BtcAmount btcAmount : dta100List) {
            createTimedta100List.add(format.format(btcAmount.getCreateTime()));
            dtaCount100List.add(btcAmount.getBtcCount());
        }
        resultList.add(createTimedta100List);
        resultList.add(dtaCount100List);


        //dta前10
        btcAmountQuery.setCoinType("dta");
        btcAmountQuery.setDataType(10);
        List<BtcAmount> dta10List = coinCountTimeMapper.queryTopList(btcAmountQuery);
        List<String> createTimedta10List = new ArrayList<String>();
        List<Long> dtaCount10List = new ArrayList<Long>();
        for (BtcAmount btcAmount : dta10List) {
            createTimedta10List.add(format.format(btcAmount.getCreateTime()));
            dtaCount10List.add(btcAmount.getBtcCount());
        }
        resultList.add(createTimedta10List);
        resultList.add(dtaCount10List);

        //sop前100
        btcAmountQuery.setCoinType("sop");
        btcAmountQuery.setDataType(3);
        List<BtcAmount> sop100List = coinCountTimeMapper.queryTopList(btcAmountQuery);
        List<String> createTimeSop100List = new ArrayList<String>();
        List<Long> sopCount100List = new ArrayList<Long>();
        for (BtcAmount btcAmount : sop100List) {
            createTimeSop100List.add(format.format(btcAmount.getCreateTime()));
            sopCount100List.add(btcAmount.getBtcCount());
        }
        resultList.add(createTimeSop100List);
        resultList.add(sopCount100List);


        return new Gson().toJson(resultList);
    }

    /**
     * 山寨币前100持仓列表
     *
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/token_top_list_v2", method = RequestMethod.GET)
    public String tokenTopListV2() {


        // 查询出需要查询的ico列表
        IcoTokenQuery icoTokenQuery = new IcoTokenQuery();
        icoTokenQuery.setNeedShow(1);
        long startQuery = System.currentTimeMillis();
        List<IcoToken> icoTokenList = icoTokenMapper.findNeedList(icoTokenQuery);
        System.out.println("新版查询时间====" + (System.currentTimeMillis() - startQuery));
        List<String> needIcoTokenList = new ArrayList<String>();

        List<Object> resultListV2 = new ArrayList<Object>();

        Map<String, IcoToken> resultIcoTokenMap = new HashMap<String, IcoToken>();

        long startDeal = System.currentTimeMillis();
        for (IcoToken icoToken : icoTokenList) {
            needIcoTokenList.add(icoToken.getTokenName());
            //再将返回前端的内容整理下
            String chartsName = icoToken.getChartsName();
            String needCountNumber = icoToken.getNeedCountNumber();
            String[] chartsNameSplit = chartsName.split(",");
            String[] needCountNumberSplit = needCountNumber.split(",");

            for (int i = 0; i < chartsNameSplit.length; i++) {
                String tokenNameKey = icoToken.getTokenName() + needCountNumberSplit[i];
                IcoToken resultToken = new IcoToken(icoToken.getTokenName(), icoToken.getIcoNumber(), chartsNameSplit[i], 0L);
                resultIcoTokenMap.put(tokenNameKey, resultToken);
            }
        }


        CoinCountTimeQuery coinCountTimeQuery = new CoinCountTimeQuery();
        coinCountTimeQuery.setNeedIcoTokenList(needIcoTokenList);
        List<CoinCountTime> coinCountTimeList = coinCountTimeMapper.queryTopListV2(coinCountTimeQuery);


        //循环具体每个时间段的数据
        Map<String, List<CoinCountTime>> resultMap = new HashMap<String, List<CoinCountTime>>();
        for (CoinCountTime coinCountTime : coinCountTimeList) {
            //如果dataType是3代表查询前100的地址
            Integer dataType = coinCountTime.getDataType();
            if (dataType == 3) {
                dataType = 100;
            }
            //生成key的值
            String resultCoin = coinCountTime.getCoinType() + dataType;

            if (resultMap.containsKey(resultCoin)) {
                //如果包含,取出来添加一个
                List<CoinCountTime> everyCoinList = resultMap.get(resultCoin);
                everyCoinList.add(coinCountTime);
            } else {
                //不包含,创建一个
                List<CoinCountTime> coinList = new ArrayList<CoinCountTime>();
                coinList.add(coinCountTime);
                resultMap.put(resultCoin, coinList);
            }
        }

        resultListV2.add(resultIcoTokenMap);
        resultListV2.add(resultMap);

        System.out.println("新版处理时间时间====" + (System.currentTimeMillis() - startDeal));

        String result = new Gson().toJson(resultListV2);

        return result;
    }


}
