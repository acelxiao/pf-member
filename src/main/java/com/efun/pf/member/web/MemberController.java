package com.efun.pf.member.web;


import com.efun.pf.member.config.platform.Platforms;
import com.efun.pf.member.config.platform.PlatformsFactory;
import com.efun.pf.member.entity.Member;
import com.efun.pf.member.entity.MemberAward;
import com.efun.pf.member.params.MemberParam;
import com.efun.pf.member.params.StoreParam;
import com.efun.pf.member.service.MemberService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;
import utils.R;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Acel
 * @since 2017/12/21
 */
@RestController
@RequestMapping({"/member"})
@Api(description = "会员相关操作")
public class MemberController {

    @Autowired
    MemberService memberService;

    @ApiOperation(value="新增平台会员")
    @RequestMapping(value = {"/create"}, method = RequestMethod.GET)
    public Object create(Member member){
        return R.ok(memberService.createMember(member));
    }

    @ApiOperation(value="获取会员平台信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name="uid",value="用户id",dataType="String",required = true,paramType = "query")})
    @RequestMapping(value = {"/get"}, method = RequestMethod.GET)
    public Object get(String uid){
        return R.ok(memberService.getMember(uid));
    }

    @ApiOperation(value="查询会员扩展信息")
    @RequestMapping(value = {"/queryExtInfo"}, method = RequestMethod.GET)
    public Object queryExtInfo(@Validated @ApiIgnore MemberParam memberParam){
        return R.ok(memberService.queryExtInfo(memberParam.getUid(), PlatformsFactory.create(memberParam.getPlatform())));
    }

    @ApiOperation(value="增加/扣除会员积分")
    @ApiImplicitParams({
            @ApiImplicitParam(name="uid",value="用户id",dataType="String",required = true,paramType = "query"),
            @ApiImplicitParam(name="goldValue",value="积分值",dataType="int",required = true,paramType = "query"),
            @ApiImplicitParam(name="awardType",value="奖励来源1",dataType="String",required = true,paramType = "query"),
            @ApiImplicitParam(name="sourceType",value="奖励来源2",dataType="String",required = false,paramType = "query")
    })
    @RequestMapping(value = {"/addGoldValue"}, method = RequestMethod.GET)
    public Object addGoldValue(String uid, int goldValue, String awardType, String sourceType){
        Member member = memberService.getMember(uid);
        MemberAward memberAward = new MemberAward.Builder().uid(uid).cpoints(goldValue)
                .tpoints(member.getGoldValue()).type(MemberAward.type.integral.name())
                .awardType(awardType).sourceType(sourceType).build();
        return R.ok(memberService.addGoldValue(memberAward));
    }


    @ApiOperation(value="查询会员储值信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name="uid",value="用户id",dataType="String",required = true,paramType = "query"),
            @ApiImplicitParam(name="storeEndTime",value="结束时间",dataType="Date",required = false,paramType = "query"),
            @ApiImplicitParam(name="storeStartTime",value="开始时间",dataType="Date",required = false,paramType = "query"),
            @ApiImplicitParam(name="payType",value="储值方式",dataType="String",required = false,paramType = "query"),
            @ApiImplicitParam(name="gameCodes",value="游戏.多个逗号隔开",dataType="String",required = false,paramType = "query")
    })
    @RequestMapping(value = {"/queryStoreInfo"}, method = RequestMethod.GET)
    public Object queryStoreInfo(@Validated @ApiIgnore StoreParam storeParam){
        return R.ok(memberService.queryStoreInfo(storeParam));
    }

    @InitBinder
    protected void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    }
}
