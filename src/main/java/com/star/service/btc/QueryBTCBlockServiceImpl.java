package com.star.service.btc;

import com.google.gson.Gson;
import com.star.dao.BtcTransactionHistoryDAO;
import com.star.dao.BtcWalletDAO;
import com.star.model.btc.*;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * @Author 张楠
 * @Date 2018-06-2018/6/16 上午11:01
 * @Describe
 * @Version
 * @since
 */
@Service
public class QueryBTCBlockServiceImpl implements QueryBTCBlockService {


    @Resource
    private BtcWalletDAO btcWalletDAO;

    @Resource
    private BtcTransactionHistoryDAO btcTransactionHistoryDAO;


    @Override
    public void queryBlock() {

        //获取最大的钱包编号,用于之后创建新的钱包的时候标记
        Long maxBlockId = 0L;
        BtcWallet maxBtcWallet = btcWalletDAO.findMaxWalletBlock();
        if (null != maxBtcWallet) {
            maxBlockId = maxBtcWallet.getBlockId();
        }

        try {
            int index = 31736;
            while (index < 99999999) {

                // 请求获取区块
                BlockList blockList = postBlock(index);

                if (null == blockList) {
                    Thread.sleep(1000);
                    continue;
                }
                System.out.println(Thread.currentThread().getName() + "height========" + blockList.getBlocks().get(0).getHeight());


                //1.查看是否有该地址
                //2.如果有---> 更新金额 else ----> 创建钱包地址
                //查询是否有地址
                List<Block> blockListForIter = blockList.getBlocks();
                List<BtcWallet> createBtcWalletList = new ArrayList<BtcWallet>();
                List<OutList> allOutList = new ArrayList<OutList>();

                for (Block block : blockListForIter) {
                    List<Tx> txList = block.getTx();
                    for (Tx tx : txList) {
                        //这个是入账的地址
                        allOutList.addAll(tx.getOut());
                    }
                }

                //只有在输入钱包size>0才调用
                if (!allOutList.isEmpty()) {
                    List<BtcWallet> btcWallet = btcWalletDAO.findByAddressList(allOutList);
                    for (OutList out : allOutList) {
                        boolean needCreate = true;
                        for (BtcWallet wallet : btcWallet) {
                            if (wallet.getBtcAddress().equals(out.getAddr())) {
                                needCreate = false;
                                break;
                            }
                        }
                        if (needCreate) {
                            //创建钱包
                            maxBlockId++;
                            BtcWallet createBtcWallet = new BtcWallet(maxBlockId, out.getAddr(), 0L, blockListForIter.get(0).getTime() + "", blockListForIter.get(0).getTime() + "");
                            createBtcWalletList.add(createBtcWallet);
                        }
                    }
                }

                if (!createBtcWalletList.isEmpty()) {
                    btcWalletDAO.createBtcWalletBatch(createBtcWalletList);
                }


                //记录交易历史记录

                /*
                * 1.单个打给单个
                * 2.单个打给多个
                * 3.多个打给单个
                * 4.多个打给多个
                *
                * input是出,output是进
                */
                HashSet<String> inputAndOutAddressSet = new HashSet<String>();
                //2.再遍历进的
                List<BtcTransactionHistory> createHistoryList = new ArrayList<BtcTransactionHistory>();
                for (Block block : blockListForIter) {
                    List<Tx> txList = block.getTx();
                    for (Tx tx : txList) {
                        List<InputList> inputList = tx.getInputs();
                        for (InputList input : inputList) {
                            //出
                            PrevOut prevOut = input.getPrevOut();
                            if (null != prevOut) {

                                BtcTransactionHistory btcTransactionHistory = new BtcTransactionHistory(prevOut.getAddr(), block.getTime() + "", -prevOut.getValue(),
                                        block.getHeight(), block.getHash(), 1);
                                createHistoryList.add(btcTransactionHistory);
                                inputAndOutAddressSet.add(prevOut.getAddr());
                                //更新钱包的数量,减掉比特币
                                //BtcWallet reducesBtc = new BtcWallet();
                                //reducesBtc.setBtcAddress(prevOut.getAddr());
                                //reducesBtc.setBtcAmount(prevOut.getValue());
                                //reducesBtc.setUpdateTime(block.getTime() + "");
                                //btcWalletDAO.reducesBtc(reducesBtc);
                            }
                        }
                        List<OutList> outList = tx.getOut();
                        for (OutList out : outList) {
                            //进
                            BtcTransactionHistory btcTransactionHistory = new BtcTransactionHistory(out.getAddr(), block.getTime() + "", out.getValue(),
                                    block.getHeight(), block.getHash(), 2);
                            createHistoryList.add(btcTransactionHistory);
                            inputAndOutAddressSet.add(out.getAddr());
                            //更新钱包的数量,增加比特币
                            //BtcWallet reducesBtc = new BtcWallet();
                            //reducesBtc.setBtcAddress(out.getAddr());
                            //reducesBtc.setBtcAmount(out.getValue());
                            //reducesBtc.setUpdateTime(block.getTime() + "");
                            //btcWalletDAO.addBtc(reducesBtc);
                        }
                    }
                }
                btcTransactionHistoryDAO.createBatch(createHistoryList);

                //最后需要跟新btc_wallet表的余额
                for (Block block : blockListForIter) {
                    //先把有些wallet的余额为null置为0
                    if (!inputAndOutAddressSet.isEmpty()) {
                        //btcWalletDAO.updateAmountFromNullToZero();
                        //更新余额
                        BtcWallet btcWalletForUpdateAmount = new BtcWallet();
                        btcWalletForUpdateAmount.setHash(block.getHash());
                        btcWalletForUpdateAmount.setUpdateTime(block.getTime() + "");
                        btcWalletForUpdateAmount.setInputAndOutAddressSet(inputAndOutAddressSet);
                        btcWalletDAO.updateBtcWalletAmount(btcWalletForUpdateAmount);
                    }

                }
                index++;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     * 请求获取区块
     *
     * @param index 区块号
     * @return
     * @throws Exception
     */
    public BlockList postBlock(int index) throws Exception {
        HttpResponse response = new DefaultHttpClient().execute(new HttpGet("https://blockchain.info/zh-cn/block-height/" + index + "?format=json"));
        int statusCode = response.getStatusLine().getStatusCode();
        if (statusCode != 200) {
            return null;
        }
        String json2 = EntityUtils.toString(response.getEntity(), "utf-8");
        return new Gson().fromJson(json2, BlockList.class);
    }


}
