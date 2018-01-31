package com.efun.pf.member.config.platform;

/**
 * @author Acel
 * @since 2017/12/25
 */
public class TwPlatform implements Platforms {
    @Override
    public String getPlatformCode() {
        return "tw";
    }

    @Override
    public String getPlatformGameCode() {
        return "platForm";
    }

    @Override
    public String getLoginHost() {
        return "https://login.efuntw.com/";
    }

    @Override
    public String getPayHost() {
        return "https://pay.efuntw.com/";
    }
}
