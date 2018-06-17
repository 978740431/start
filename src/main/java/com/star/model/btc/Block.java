package com.star.model.btc;

import java.util.List;

/**
 * @Author 张楠
 * @Date 2018-06-2018/6/17 下午12:00
 * @Describe
 * @Version
 * @since
 */
public class Block {

    /*
                "hash":"000000000003ba27aa200b1cecaad478d2b00432346c3f1f3986da1afd33e506",
            "ver":1,
            "prev_block":"000000000002d01c1fccc21636b607dfd930d31d01c3a62104612a1719011250",
            "mrkl_root":"f3e94742aca4b5ef85488dc37c06c3282295ffec960994b2c0d5ac2a25a95766",
            "time":1293623863,
            "bits":453281356,
            "fee":0,
            "nonce":274148111,
            "n_tx":4,
            "size":957,
            "block_index":114850,
            "main_chain":true,
            "height":100000,
    */
    private String hash;
    private Integer ver;
    private String prev_block;
    private String mrkl_root;
    private Long time;
    private Long bits;
    private Integer fee;
    private Long nonce;
    private Integer n_tx;
    private Integer size;
    private Long block_index;
    private Boolean main_chain;
    private Long height;
    private List<Tx> tx;

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    public Integer getVer() {
        return ver;
    }

    public void setVer(Integer ver) {
        this.ver = ver;
    }

    public String getPrev_block() {
        return prev_block;
    }

    public void setPrev_block(String prev_block) {
        this.prev_block = prev_block;
    }

    public String getMrkl_root() {
        return mrkl_root;
    }

    public void setMrkl_root(String mrkl_root) {
        this.mrkl_root = mrkl_root;
    }

    public Long getTime() {
        return time;
    }

    public void setTime(Long time) {
        this.time = time;
    }

    public Long getBits() {
        return bits;
    }

    public void setBits(Long bits) {
        this.bits = bits;
    }

    public Integer getFee() {
        return fee;
    }

    public void setFee(Integer fee) {
        this.fee = fee;
    }

    public Long getNonce() {
        return nonce;
    }

    public void setNonce(Long nonce) {
        this.nonce = nonce;
    }

    public Integer getN_tx() {
        return n_tx;
    }

    public void setN_tx(Integer n_tx) {
        this.n_tx = n_tx;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public Long getBlock_index() {
        return block_index;
    }

    public void setBlock_index(Long block_index) {
        this.block_index = block_index;
    }

    public Boolean getMain_chain() {
        return main_chain;
    }

    public void setMain_chain(Boolean main_chain) {
        this.main_chain = main_chain;
    }

    public Long getHeight() {
        return height;
    }

    public void setHeight(Long height) {
        this.height = height;
    }

    public List<Tx> getTx() {
        return tx;
    }

    public void setTx(List<Tx> tx) {
        this.tx = tx;
    }
}
