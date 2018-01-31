package com.efun.pf.member.service.impl.kr;

import com.efun.pf.member.service.impl.MemberServiceAbstractImpl;
import org.springframework.stereotype.Service;

/**
 * @author Acel
 * @since 2017/12/21
 */
@Service("memberService")
public class KrMemberServiceImpl extends MemberServiceAbstractImpl {

    @Override
    public String createMemberSpecial() {
        return "KR特殊逻辑执行了";
    }

    @Override
    public String specialHandle(String s) {
        return "----加上了韩国特殊逻辑";
    }
}
