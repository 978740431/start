package com.star.model.btc;

import java.util.List;

/**
 * @Author 张楠
 * @Date 2018-06-2018/6/17 下午12:03
 * @Describe
 * @Version
 * @since
 */
public class Tx {


    /*                    "lock_time":0,
                    "ver":1,
                    "size":259,
                    "inputs":Array[1],
                    "weight":1036,
                    "time":1293623863,
                    "tx_index":240046,
                    "vin_sz":1,
                    "hash":"fff2525b8931402dd09222c50775608f75787bd2b87e56995a7bdd30f79702c4",
                    "vout_sz":2,
                    "relayed_by":"0.0.0.0",
                    "out":Array[2]
                    */


    private Integer lock_time;
    private Integer ver;
    private Integer size;
    private List<InputList> inputs;
    private Integer weight;
    private Long time;
    private Long tx_index;
    private Integer vin_sz;
    private String hash;
    private Integer vout_sz;
    private String relayed_by;
    private List<OutList> out;

    public Integer getLock_time() {
        return lock_time;
    }

    public void setLock_time(Integer lock_time) {
        this.lock_time = lock_time;
    }

    public Integer getVer() {
        return ver;
    }

    public void setVer(Integer ver) {
        this.ver = ver;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public List<InputList> getInputs() {
        return inputs;
    }

    public void setInputs(List<InputList> inputs) {
        this.inputs = inputs;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public Long getTime() {
        return time;
    }

    public void setTime(Long time) {
        this.time = time;
    }

    public Long getTx_index() {
        return tx_index;
    }

    public void setTx_index(Long tx_index) {
        this.tx_index = tx_index;
    }

    public Integer getVin_sz() {
        return vin_sz;
    }

    public void setVin_sz(Integer vin_sz) {
        this.vin_sz = vin_sz;
    }

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    public Integer getVout_sz() {
        return vout_sz;
    }

    public void setVout_sz(Integer vout_sz) {
        this.vout_sz = vout_sz;
    }

    public String getRelayed_by() {
        return relayed_by;
    }

    public void setRelayed_by(String relayed_by) {
        this.relayed_by = relayed_by;
    }

    public List<OutList> getOut() {
        return out;
    }

    public void setOut(List<OutList> out) {
        this.out = out;
    }
}
