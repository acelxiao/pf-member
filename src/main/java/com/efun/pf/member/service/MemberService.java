package com.efun.pf.member.service;

import com.alibaba.fastjson.JSONObject;
import com.efun.pf.member.config.platform.Platforms;
import com.efun.pf.member.dto.MemberExt;
import com.efun.pf.member.entity.Member;
import com.efun.pf.member.entity.MemberAward;
import com.efun.pf.member.params.StoreParam;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;


/**
 * @author Acel
 * @since 2017/12/21
 */
public interface MemberService {

    Member createMember(Member member);

    Member getMember(String uid);

    int addGoldValue(MemberAward memberAward);

    MemberExt queryExtInfo(String uid, Platforms platforms);

    JSONObject queryStoreInfo(StoreParam storeParam);

    JSONObject listStoreInfo(Date storeStartTime, Date storeEndTime, String gameCode, String payType, int currentPage, int pageSize, String uid, Platforms platforms);
}
