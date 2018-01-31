package com.efun.pf.member.params;

import javax.validation.constraints.NotNull;

/**
 * @author Acel
 * @since 2017/12/25
 */
public class MemberParam extends BaseParam {

    @NotNull(message = "uid不能为空")
    private String uid;

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }
}
