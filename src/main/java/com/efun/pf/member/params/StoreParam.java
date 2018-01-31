package com.efun.pf.member.params;

import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * @author Acel
 * @since 2017/12/25
 */
public class StoreParam extends BaseParam {

    @NotNull(message = "uid不能为空")
    private String uid;

    private Date storeEndTime;

    private Date storeStartTime;

    private String gameCodes;

    private String payType;

    public Date getStoreEndTime() {
        return storeEndTime;
    }

    public void setStoreEndTime(Date storeEndTime) {
        this.storeEndTime = storeEndTime;
    }

    public Date getStoreStartTime() {
        return storeStartTime;
    }

    public void setStoreStartTime(Date storeStartTime) {
        this.storeStartTime = storeStartTime;
    }

    public String getGameCodes() {
        return gameCodes;
    }

    public void setGameCodes(String gameCodes) {
        this.gameCodes = gameCodes;
    }

    public String getPayType() {
        return payType;
    }

    public void setPayType(String payType) {
        this.payType = payType;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }
}
