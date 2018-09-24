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


        BtcAmountQuery btcAmountQuery = new BtcAmountQuery();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");


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

        //btc 10~100
        btcAmountQuery.setCoinType("btc");
        btcAmountQuery.setDataType(11);
        List<BtcAmount> btcAmount10100List = coinCountTimeMapper.queryTopList(btcAmountQuery);
        List<String> btcCreateTime10100List = new ArrayList<String>();
        List<Long> btcCount10100List = new ArrayList<Long>();
        for (BtcAmount btcAmount : btcAmount10100List) {
            btcCreateTime10100List.add(format.format(btcAmount.getCreateTime()));
            btcCount10100List.add(btcAmount.getBtcCount());
        }
        resultList.add(btcCreateTime10100List);
        resultList.add(btcCount10100List);


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


        //btc 前500
        btcAmountQuery.setCoinType("btc");
        btcAmountQuery.setDataType(1);
        List<BtcAmount> btcAmountList = coinCountTimeMapper.queryTopList(btcAmountQuery);

        List<String> createTimeList = new ArrayList<String>();
        List<Long> btcCountList = new ArrayList<Long>();
        for (BtcAmount btcAmount : btcAmountList) {
            createTimeList.add(format.format(btcAmount.getCreateTime()));
            btcCountList.add(btcAmount.getBtcCount());
        }
        resultList.add(createTimeList);
        resultList.add(btcCountList);


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

        return new Gson().toJson(resultList);
    }


    /**
     * bch前500持仓列表
     *
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/bch_top_list", method = RequestMethod.GET)
    public String bchTopList() {

        //返回的list
        List<Object> resultList = new ArrayList<Object>();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");


        //bch 前10
        BtcAmountQuery btcAmountQuery = new BtcAmountQuery();
        btcAmountQuery.setCoinType("bch");
        btcAmountQuery.setDataType(24);
        List<BtcAmount> btcAmount10List = coinCountTimeMapper.queryTopList(btcAmountQuery);
        List<String> btcCreateTime10List = new ArrayList<String>();
        List<Long> btcCount10List = new ArrayList<Long>();
        for (BtcAmount btcAmount : btcAmount10List) {
            btcCreateTime10List.add(format.format(btcAmount.getCreateTime()));
            btcCount10List.add(btcAmount.getBtcCount());
        }
        resultList.add(btcCreateTime10List);
        resultList.add(btcCount10List);

        //bch 前100
        btcAmountQuery.setDataType(22);
        btcAmountQuery.setCoinType("bch");
        List<BtcAmount> btcAmount100List = coinCountTimeMapper.queryTopList(btcAmountQuery);
        List<String> createTime100List = new ArrayList<String>();
        List<Long> btcCount100List = new ArrayList<Long>();
        for (BtcAmount btcAmount : btcAmount100List) {
            createTime100List.add(format.format(btcAmount.getCreateTime()));
            btcCount100List.add(btcAmount.getBtcCount());
        }
        resultList.add(createTime100List);
        resultList.add(btcCount100List);


        //bch 前500
        btcAmountQuery.setCoinType("bch");
        btcAmountQuery.setDataType(20);
        List<BtcAmount> btcAmountList = coinCountTimeMapper.queryTopList(btcAmountQuery);

        List<String> createTimeList = new ArrayList<String>();
        List<Long> btcCountList = new ArrayList<Long>();
        for (BtcAmount btcAmount : btcAmountList) {
            createTimeList.add(format.format(btcAmount.getCreateTime()));
            btcCountList.add(btcAmount.getBtcCount());
        }
        resultList.add(createTimeList);
        resultList.add(btcCountList);

        //bch 前1000
        btcAmountQuery.setDataType(23);
        btcAmountQuery.setCoinType("bch");
        List<BtcAmount> btcAmount1000List = coinCountTimeMapper.queryTopList(btcAmountQuery);
        List<String> createTime1000List = new ArrayList<String>();
        List<Long> btcCount1000List = new ArrayList<Long>();
        for (BtcAmount btcAmount : btcAmount1000List) {
            createTime1000List.add(format.format(btcAmount.getCreateTime()));
            btcCount1000List.add(btcAmount.getBtcCount());
        }
        resultList.add(createTime1000List);
        resultList.add(btcCount1000List);


        //bch 前1500
        btcAmountQuery.setCoinType("bch");
        btcAmountQuery.setDataType(21);
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

    /**
     * 山寨币前100持仓列表
     *
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/token_top_list_v2", method = RequestMethod.GET)
    public String tokenTopListV2(String iconName) {

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        long totalStartTime = System.currentTimeMillis();
        // 查询出需要查询的ico列表
        IcoTokenQuery icoTokenQuery = new IcoTokenQuery();
        icoTokenQuery.setNeedShow(1);
        icoTokenQuery.setTokenName(iconName);
        long startQuery = System.currentTimeMillis();
        List<IcoToken> icoTokenList = icoTokenMapper.findNeedList(icoTokenQuery);
        System.out.println("新版查询时间====" + (System.currentTimeMillis() - startQuery));
        List<String> needIcoTokenList = new ArrayList<String>();

        List<Object> resultListV2 = new ArrayList<Object>();

        Map<String, IcoToken> resultIcoTokenMap = new HashMap<String, IcoToken>();

        long startDeal = System.currentTimeMillis();
        //需要排除的山寨币
        List<String> excludeIcoList = new ArrayList<String>();
        if (null == iconName || "".equals(iconName)) {
            excludeIcoList.add("iost");
            excludeIcoList.add("soc");
            excludeIcoList.add("lba");
            excludeIcoList.add("elf");
            excludeIcoList.add("dta");
        }

        for (IcoToken icoToken : icoTokenList) {
            int indexExclude = 0;
            for (String s : excludeIcoList) {
                if (icoToken.getTokenName().contains(s)) {
                    indexExclude = 1;
                    break;
                }
            }
            if (indexExclude == 1) {
                continue;
            }
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
        Map<String, List<List>> resultMap = new HashMap<String, List<List>>(icoTokenList.size());
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
                List<List> everyCoinList = resultMap.get(resultCoin);
                everyCoinList.get(0).add(format.format(coinCountTime.getCreateTime()));
                everyCoinList.get(1).add(coinCountTime.getCoinCount());
                // 将初始值赋给最小值
                IcoToken icoToken = resultIcoTokenMap.get(resultCoin);
                if (icoToken.getMinCount() > coinCountTime.getCoinCount()) {
                    icoToken.setMinCount(coinCountTime.getCoinCount());
                }
            } else {
                //不包含,创建一个
                List<List> coinList = new ArrayList<List>(1000);
                List<String> createTimeList = new ArrayList<String>(1000);
                List<Long> countTimeList = new ArrayList<Long>(1000);
                createTimeList.add(format.format(coinCountTime.getCreateTime()));
                countTimeList.add(coinCountTime.getCoinCount());
                coinList.add(createTimeList);
                coinList.add(countTimeList);
                resultMap.put(resultCoin, coinList);
                // 将初始值赋给最小值
                IcoToken icoToken = resultIcoTokenMap.get(resultCoin);
                icoToken.setMinCount(coinCountTime.getCoinCount());
            }
        }

        resultListV2.add(resultIcoTokenMap);
        resultListV2.add(resultMap);

        System.out.println("新版处理时间时间====" + (System.currentTimeMillis() - startDeal));

        String result = new Gson().toJson(resultListV2);

        System.out.println("新版总共处理时间=====" + (System.currentTimeMillis() - totalStartTime));
        return result;
    }

}
