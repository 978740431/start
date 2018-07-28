package com.star.model.btc;

/**
 * @Author 张楠
 * @Date 2018-06-2018/6/23 下午5:13
 * @Describe
 * @Version
 * @since
 */
public class SingleTokenInfo {


    private String id;
    private String symbol;
    private Tokenlink links;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public Tokenlink getLinks() {
        return links;
    }

    public void setLinks(Tokenlink links) {
        this.links = links;
    }
}
