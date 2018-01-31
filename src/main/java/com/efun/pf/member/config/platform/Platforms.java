package com.efun.pf.member.config.platform;

/**
 * @author Acel
 * @since 2017/12/25
 */
public interface Platforms {
    /**
     * 获取平台标识
     * @return
     */
    String getPlatformCode();
    /**
     * 获取平台gameCode
     * @return
     */
    String getPlatformGameCode();
    /**
     * 获取登陆url
     * @return
     */
    String getLoginHost();

    /**
     * 获取储值url
     * @return
     */
    String getPayHost();
}
