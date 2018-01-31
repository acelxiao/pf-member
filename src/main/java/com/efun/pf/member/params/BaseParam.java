package com.efun.pf.member.params;

import javax.validation.constraints.NotNull;


/**
 * @author Acel
 * @since 2017/10/23
 */
public class BaseParam {
    @NotNull(message = "platform不能为空")
    private String platform;
    @NotNull(message = "language不能为空")
    private String language;
    @NotNull(message = "from不能为空")
    private String from; // 记录访问来源固定取值: app/sdk/mb/pc/其他工程标识

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform){
        this.platform = platform;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

}
