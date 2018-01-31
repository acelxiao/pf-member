package com.efun.pf.member.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.efun.pf.member.config.platform.Platforms;
import com.efun.pf.member.config.platform.PlatformsFactory;
import com.efun.pf.member.dto.MemberExt;
import com.efun.pf.member.entity.Member;
import com.efun.pf.member.entity.MemberAward;
import com.efun.pf.member.params.StoreParam;
import com.efun.pf.member.repository.MemberAwardRepository;
import com.efun.pf.member.repository.MemberRepository;
import com.efun.pf.member.service.MemberService;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import utils.HttpUtil;

import javax.validation.constraints.Null;
import java.util.Date;
import java.util.HashMap;

/**
 * @author Acel
 * @since 2017/12/21
 */
public abstract class MemberServiceAbstractImpl implements MemberService {

    @Autowired
    MemberRepository memberRepository;

    @Autowired
    MemberAwardRepository memberAwardRepository;

    @Override
    public Member createMember(Member member) {
        String special = createMemberSpecial();
        System.out.println(special);

        System.out.println("公共逻辑执行了");
        return memberRepository.save(member);
    }

    public abstract String createMemberSpecial();

    @Override
    public Member getMember(String uid) {
        return memberRepository.findByUid(uid);
    }

    public abstract String specialHandle(String s);

    @Transactional(rollbackFor = Exception.class)
    @Override
    public int addGoldValue(MemberAward memberAward) {
        if (memberAwardRepository.save(memberAward) != null){
            return memberRepository.addGoldValue(memberAward.getCpoints(), memberAward.getUid());
        }
        return 0;
    }

    @Override
    public MemberExt queryExtInfo(String uid, Platforms platforms) {
        try {
            String url = platforms.getLoginHost() + "assist_loadUserExpandMsg.shtml";
            HashMap<String, String> map = new HashMap<>();
            map.put("crossdomain", "false");
            map.put("userId", uid);
            String result = HttpUtil.doGet(url, map);
            return JSON.parseObject(result, MemberExt.class);
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public JSONObject queryStoreInfo(StoreParam storeParam) {
        try {
            Platforms platforms = PlatformsFactory.create(storeParam.getPlatform());
            StringBuffer url = new StringBuffer().append(platforms.getPayHost())
                    .append("activityPay_getPaySum.shtml?uid=").append(storeParam.getUid());
            if (StringUtils.isNotBlank(storeParam.getGameCodes())) {
                url.append("&gameCode=").append(storeParam.getGameCodes());
            }
            if (storeParam.getStoreStartTime() != null) {
                url.append("&startTime=").append(storeParam.getStoreStartTime().getTime());
            }
            if (storeParam.getStoreEndTime() != null) {
                url.append("&endTime=").append(storeParam.getStoreEndTime().getTime());
            }
            if (StringUtils.isNotBlank(storeParam.getPayType())) {
                url.append("&flag=").append(storeParam.getPayType());
            }
            String result = HttpUtil.sendGetRequest(url.toString());
            JSONObject jsonResult = JSON.parseObject(result);
            return jsonResult;
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public JSONObject listStoreInfo(Date storeStartTime, Date storeEndTime, String gameCode, String payType, int currentPage, int pageSize, String uid, Platforms platforms) {
        return null;
    }
}
