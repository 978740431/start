package com.star.service.btc;

import com.star.dao.BtcWalletDAO;
import com.star.model.btc.BtcWallet;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Author 张楠
 * @Date 2018-06-2018/6/16 上午11:01
 * @Describe
 * @Version
 * @since
 */
@Service
public class QueryBTCBlockServiceImpl implements QueryBTCBlockService{


    @Resource
    private BtcWalletDAO btcWalletDAO;


    public void queryBlock() {

        try {
            // 请求获取区块
            /*HttpResponse response = new DefaultHttpClient().execute(new HttpGet("https://blockchain.info/zh-cn/block-height/100000?format=json"));
            String json2 = EntityUtils.toString(response.getEntity(), "utf-8");
            System.out.println(json2);
            blockList blockList = new Gson().fromJson(json2, blockList.class);
*/
            BtcWallet btcWallet = new BtcWallet(1L,"aaa",1L,"111");

            btcWalletDAO.createBtcWallet(btcWallet);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        QueryBTCBlockServiceImpl queryBTCBlockServiceImpl = new QueryBTCBlockServiceImpl();
        queryBTCBlockServiceImpl.queryBlock();
    }
}
