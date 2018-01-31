package com.efun.pf.member.service.impl.tw;

import com.efun.pf.member.service.impl.MemberServiceAbstractImpl;
import org.springframework.stereotype.Service;

/**
 * @author Acel
 * @since 2017/12/21
 */
@Service("memberService")
public class TwMemberServiceImpl extends MemberServiceAbstractImpl {


    @Override
    public String createMemberSpecial() {
        return "TW特殊逻辑执行了";
    }

    @Override
    public String specialHandle(String s) {
        return "----加上了台湾特殊逻辑";
    }
}
