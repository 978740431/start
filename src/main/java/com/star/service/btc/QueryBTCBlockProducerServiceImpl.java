package com.star.service.btc;

import com.google.gson.Gson;
import com.star.model.btc.BlockList;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author 张楠
 * @Date 2018-06-2018/6/20 下午5:46
 * @Describe
 * @Version
 * @since
 */
@Service
public class QueryBTCBlockProducerServiceImpl implements QueryBTCBlockProducerService, Runnable {

    private final Log log = LogFactory.getLog(this.getClass());

    /**
     * 线程安全的int类
     * 不需要+1
     */
    public static AtomicInteger number = new AtomicInteger(69266);

    /**
     * 请求
     */
    @Override
    public void run() {
        try {
            //需要+1
            //int index = 50691;

            //DefaultHttpClient defaultHttpClient = new DefaultHttpClient();
            HttpClient httpClient = HttpClientBuilder.create().build();

            //设置超时时间
            //setConnectTimeout：设置连接超时时间，单位毫秒。
            //setConnectionRequestTimeout：设置从connect Manager获取Connection 超时时间，单位毫秒。这个属性是新加的属性，因为目前版本是可以共享连接池的。
            //setSocketTimeout：请求获取数据的超时时间，单位毫秒。 如果访问一个接口，多少时间内无法返回数据，就直接放弃此次调用。
            RequestConfig requestConfig = RequestConfig.custom()
                    .setConnectTimeout(5000).setConnectionRequestTimeout(5000)
                    .setSocketTimeout(5000).build();

            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            //TODO 修改时间
            Date parse = format.parse("2018-06-23 20:00:00");
            boolean before = new Date().before(parse);
            while (before) {
                int andIncrement = number.incrementAndGet();

                //Thread.sleep(50);
                HttpGet httpGet = new HttpGet("https://blockchain.info/zh-cn/block-height/" + andIncrement + "?format=json");
                httpGet.setConfig(requestConfig);

                //防止报错跳出循环
                String json2 = getHttpResponse(httpClient, httpGet);

                BlockList blockList = new Gson().fromJson(json2, BlockList.class);

                blockingQueue.put(blockList);
                log.info(Thread.currentThread().getName() + "======produce========" + andIncrement);
                //index++;
                before = new Date().before(parse);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 请求区块
     * @param httpClient
     * @param httpGet
     * @return
     */
    private String getHttpResponse(HttpClient httpClient, HttpGet httpGet) {

        boolean flag = true;
        String json2 = null;
        while (flag) {
            try {
                HttpResponse response = httpClient.execute(httpGet);
                int statusCode = response.getStatusLine().getStatusCode();
                if (statusCode != 200) {
                    Thread.sleep(1000);
                    continue;
                }
                json2 = EntityUtils.toString(response.getEntity(), "utf-8");
                flag = false;
            } catch (Exception e) {
                e.printStackTrace();
                try {
                    //sleep 1秒再请求
                    Thread.sleep(1000);
                } catch (InterruptedException e1) {
                    e1.printStackTrace();
                }
            }
        }
        return json2;
    }
}
