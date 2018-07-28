package com.star.service.btc;

import com.star.dao.BtcTransactionHistoryDAO;
import com.star.dao.BtcWalletDAO;
import com.star.model.btc.*;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * @Author 张楠
 * @Date 2018-06-2018/6/20 下午5:46
 * @Describe
 * @Version
 * @since
 */
@Service
public class QueryBTCBlockConsumerServiceImpl implements QueryBTCBlockProducerService, Runnable {

    private final Log log = LogFactory.getLog(this.getClass());

    @Resource
    private BtcWalletDAO btcWalletDAO;

    @Resource
    private BtcTransactionHistoryDAO btcTransactionHistoryDAO;


    @Override
    public void run() {
        try {
            while (true) {

                //BlockList blockList = blockingQueue.take();
                //log.info(Thread.currentThread().getName() + "======height===================" + blockList.getBlocks().get(0).getHeight());
                //
                //BtcWallet btcWallet = new BtcWallet(10011L, "3232", 100L, "", "");
                //btcWalletDAO.createBtcWallet(btcWallet);
                //每次启动需要修改两个地方,这里是查询最大的钱包,不用+1
                Long maxBlockId = 42170L;
                BlockList blockList = blockingQueue.take();


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

                            }
                        }
                        List<OutList> outList = tx.getOut();
                        for (OutList out : outList) {
                            //进
                            BtcTransactionHistory btcTransactionHistory = new BtcTransactionHistory(out.getAddr(), block.getTime() + "", out.getValue(),
                                    block.getHeight(), block.getHash(), 2);
                            createHistoryList.add(btcTransactionHistory);
                            inputAndOutAddressSet.add(out.getAddr());

                        }
                    }
                }
                btcTransactionHistoryDAO.createBatch(createHistoryList);

                //最后需要跟新btc_wallet表的余额
                for (Block block : blockListForIter) {
                    //先把有些wallet的余额为null置为0
                    if (!inputAndOutAddressSet.isEmpty()) {
                        //更新余额
                        BtcWallet btcWalletForUpdateAmount = new BtcWallet();
                        btcWalletForUpdateAmount.setHash(block.getHash());
                        btcWalletForUpdateAmount.setUpdateTime(block.getTime() + "");
                        btcWalletForUpdateAmount.setInputAndOutAddressSet(inputAndOutAddressSet);
                        btcWalletDAO.updateBtcWalletAmount(btcWalletForUpdateAmount);
                    }

                }


                log.info(Thread.currentThread().getName() + "===consumer========" + blockList.getBlocks().get(0).getHeight());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
