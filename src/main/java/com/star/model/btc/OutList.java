package com.star.model.btc;

/**
 * @Author 张楠
 * @Date 2018-06-2018/6/17 下午12:07
 * @Describe
 * @Version
 * @since
 */
public class OutList {

    /*
    "spent":true,
    "tx_index":240046,
    "type":0,
    "addr":"1JqDybm2nWTENrHvMyafbSXXtTk5Uv5QAn",
    "value":556000000,
    "n":0,
    "script":"76a914c398efa9c392ba6013c5e04ee729755ef7f58b3288ac"*/



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
