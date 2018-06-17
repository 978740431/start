package com.star.model.btc;

/**
 * @Author 张楠
 * @Date 2018-06-2018/6/17 下午12:08
 * @Describe
 * @Version
 * @since
 */
public class PrevOut {

    /*"spent":true,
                                "tx_index":236643,
                                "type":0,
                                "addr":"1BNwxHGaFbeUBitpjy2AsKpJ29Ybxntqvb",
                                "value":5000000000,
                                "n":0,
                                "script":"76a91471d7dd96d9edda09180fe9d57a477b5acc9cad1188ac"*/

    private Boolean spent;
    private Long tx_index;
    private Integer type;
    private String addr;
    private Long value;
    private Integer n;
    private String script;

    public Boolean getSpent() {
        return spent;
    }

    public void setSpent(Boolean spent) {
        this.spent = spent;
    }

    public Long getTx_index() {
        return tx_index;
    }

    public void setTx_index(Long tx_index) {
        this.tx_index = tx_index;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public Long getValue() {
        return value;
    }

    public void setValue(Long value) {
        this.value = value;
    }

    public Integer getN() {
        return n;
    }

    public void setN(Integer n) {
        this.n = n;
    }

    public String getScript() {
        return script;
    }

    public void setScript(String script) {
        this.script = script;
    }
}
