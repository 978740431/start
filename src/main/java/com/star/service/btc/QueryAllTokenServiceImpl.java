package com.star.service.btc;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.star.mapper.ICOTokenMapper;
import com.star.model.btc.CoingeckoToken;
import com.star.model.btc.IcoToken;
import com.star.model.btc.SingleTokenInfo;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author 张楠
 * @Date 2018-06-2018/6/23 下午4:14
 * @Describe
 * @Version
 * @since
 */
@Service
public class QueryAllTokenServiceImpl implements QueryAllTokenService {

    private final Log log = LogFactory.getLog(this.getClass());

    @Resource
    private ICOTokenMapper icoTokenMapper;


    @Override
    public void queryAllToken() {

        try {
            HttpClient httpClient = HttpClientBuilder.create().build();

            RequestConfig requestConfig = RequestConfig.custom()
                    .setConnectTimeout(5000).setConnectionRequestTimeout(5000)
                    .setSocketTimeout(5000).build();

            List<CoingeckoToken> coingeckoToken = getCoingeckoTokens(httpClient, requestConfig);

            List<IcoToken> createList = new ArrayList<IcoToken>();
            for (CoingeckoToken token : coingeckoToken) {
                IcoToken icoToken = new IcoToken();
                icoToken.setTokenName(token.getSymbol());

                SingleTokenInfo singleTokenInfo = getSingleTokenInfo(httpClient, requestConfig, token.getId());
                List<String> blockchainSiteList = singleTokenInfo.getLinks().getBlockchain_site();
                for (String link : blockchainSiteList) {
                    if (null != link && link.startsWith("https://etherscan.io/token/")) {
                        log.debug(link);
                        icoToken.setToken(link.replace("https://etherscan.io/token/", ""));
                        break;
                    }
                }

                createList.add(icoToken);
            }


            icoTokenMapper.createAllToken(createList);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private List<CoingeckoToken> getCoingeckoTokens(HttpClient httpClient, RequestConfig requestConfig) throws IOException {
        HttpGet httpGet = new HttpGet("https://api.coingecko.com/api/v3/coins/list");
        httpGet.setConfig(requestConfig);

        HttpResponse response = httpClient.execute(httpGet);

        String json2 = EntityUtils.toString(response.getEntity(), "utf-8");

        return new Gson().fromJson(json2, new TypeToken<List<CoingeckoToken>>() {
        }.getType());
    }


    /**
     * 获取token的地址
     *
     * @param httpClient
     * @param requestConfig
     * @param tokenName
     * @return
     * @throws IOException
     */
    private SingleTokenInfo getSingleTokenInfo(HttpClient httpClient, RequestConfig requestConfig, String tokenName) {

        String json2 = null;
        boolean flag = true;
        while (flag) {
            try {
                HttpGet httpGet = new HttpGet("https://api.coingecko.com/api/v3/coins/" + tokenName);
                httpGet.setConfig(requestConfig);
                HttpResponse response = httpClient.execute(httpGet);
                json2 = EntityUtils.toString(response.getEntity(), "utf-8");
                flag = false;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return new Gson().fromJson(json2, SingleTokenInfo.class);
    }


    public static void main(String[] args) {
        QueryAllTokenServiceImpl queryAllTokenService = new QueryAllTokenServiceImpl();
        queryAllTokenService.queryAllToken();
    }

}
