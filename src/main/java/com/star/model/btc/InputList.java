package com.star.model.btc;

import com.google.gson.annotations.SerializedName;

/**
 * @Author 张楠
 * @Date 2018-06-2018/6/17 下午12:06
 * @Describe
 * @Version
 * @since
 */
public class InputList {

    /*"sequence":4294967295,
                            "witness":"",
                            "prev_out":{
                                "spent":true,
                                "tx_index":236643,
                                "type":0,
                                "addr":"1BNwxHGaFbeUBitpjy2AsKpJ29Ybxntqvb",
                                "value":5000000000,
                                "n":0,
                                "script":"76a91471d7dd96d9edda09180fe9d57a477b5acc9cad1188ac"
                            },
                            "script":"493046022100c352d3dd993a981beba4a63ad15c209275ca9470abfcd57da93b58e4eb5dce82022100840792bc1f456062819f15d33ee7055cf7b5ee1af1ebcc6028d9cdb1c3af7748014104f46db5e9d61a9dc27b8d64ad23e7383a4e6ca164593c2527c038c0857eb67ee8e825dca65046b82c9331586c82e0fd1f633f25f87c161bc6f8a630121df2b3d3"
                        }*/

    //序号
    private Long sequence;
    //证明
    private String witness;
    @SerializedName("prev_out")
    private PrevOut prevOut;
    //脚本
    private String script;



    public Long getSequence() {
        return sequence;
    }

    public void setSequence(Long sequence) {
        this.sequence = sequence;
    }

    public String getWitness() {
        return witness;
    }

    public void setWitness(String witness) {
        this.witness = witness;
    }

    public String getScript() {
        return script;
    }

    public void setScript(String script) {
        this.script = script;
    }


    public PrevOut getPrevOut() {
        return prevOut;
    }

    public void setPrevOut(PrevOut prevOut) {
        this.prevOut = prevOut;
    }
}
