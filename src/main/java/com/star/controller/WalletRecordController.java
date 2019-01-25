package com.star.controller;

import com.google.gson.Gson;
import com.star.common.RedisService;
import com.star.mapper.WalletRecordMapper;
import com.star.model.btc.WalletRecord;
import com.star.model.btc.WalletRecordQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by admin on 2016/6/18.
 */

@Controller
@RequestMapping("/wallet_record")
public class WalletRecordController {


    @Autowired
    private WalletRecordMapper walletRecordMapper;


    @Resource
    private RedisService redisService;

    /**
     * bch前500持仓列表
     *
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/query_list", method = RequestMethod.GET)
    public String btcWalletRecordList(String query, String exchangeName) {

        String bianance_ = redisService.get("bianance_" + query + "_" + exchangeName);
        if (null != bianance_ && !"".equals(bianance_)) {
            return bianance_;
        }
        //返回的list
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");


        //dash 前10
        WalletRecordQuery walletRecordQuery = new WalletRecordQuery();
        walletRecordQuery.setCoinType(query);
        walletRecordQuery.setExchangeName(exchangeName);
        List<WalletRecord> walletRecordList = walletRecordMapper.queryList(walletRecordQuery);

        List<String> resultTimeList = new ArrayList<String>();

        Map<String, List<WalletRecord>> walletRecordMap = new HashMap<String, List<WalletRecord>>();

        for (WalletRecord walletRecord : walletRecordList) {
            String format1 = format.format(walletRecord.getRecordTime());
            walletRecord.setOutRecordTime(format1);

            List<WalletRecord> havePutRecordList = walletRecordMap.get(walletRecord.getWalletName());
            if (null != havePutRecordList) {
                //包含，则添加
                havePutRecordList.add(walletRecord);
            } else {
                List<WalletRecord> newPutWalletRecordList = new ArrayList<WalletRecord>();
                newPutWalletRecordList.add(walletRecord);
                walletRecordMap.put(walletRecord.getWalletName(), newPutWalletRecordList);
            }
        }

        //找到最长的那一个地址
        int recordCount = 0;
        String mapKey = "";
        for (String s : walletRecordMap.keySet()) {
            if (walletRecordMap.get(s).size() > recordCount) {
                recordCount = walletRecordMap.get(s).size();
                mapKey = s;
            }
        }

        //整理x轴时间
        List<WalletRecord> maxLongWalletRecordList = walletRecordMap.get(mapKey);
        for (WalletRecord walletRecord : maxLongWalletRecordList) {
            String format1 = format.format(walletRecord.getRecordTime());
            resultTimeList.add(format1);
        }

        Map<String, Object> resultMap = new HashMap<String, Object>();
        //整理最终的数据
        for (String recordAddress : walletRecordMap.keySet()) {
            List<WalletRecord> walletRecords = walletRecordMap.get(recordAddress);
            List<String> resultWalletRecordList = new ArrayList<String>(recordCount);

            for (int i = 0; i < recordCount; i++) {
                resultWalletRecordList.add(null);
            }

            for (WalletRecord walletRecord : walletRecords) {
                int index = resultTimeList.indexOf(walletRecord.getOutRecordTime());
                if (index == -1) {
                    continue;
                }
                resultWalletRecordList.set(index, walletRecord.getCoinCount() + "");
            }
            resultMap.put(recordAddress, resultWalletRecordList);
        }
        resultMap.put("recordTime", resultTimeList);

        String resultJson = new Gson().toJson(resultMap);
        redisService.set("bianance_" + query + "_" + exchangeName, resultJson, 1800);

        return resultJson;
    }

}
