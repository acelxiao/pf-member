package com.efun.pf.member.service.impl.ae;

import com.efun.pf.member.service.impl.MemberServiceAbstractImpl;
import org.springframework.stereotype.Service;

/**
 * @author Acel
 * @since 2017/12/21
 */
@Service("memberService")
public class AEMemberServiceImpl extends MemberServiceAbstractImpl {


    @Override
    public String createMemberSpecial() {
        return "AE特殊逻辑执行了";
    }

    @Override
    public String specialHandle(String s) {
        return "----加上了亚欧特殊逻辑";
    }
}
