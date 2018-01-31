package com.efun.pf.member.entity;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

/**
 * @author Acel
 * @since 2017/12/25
 */
@Entity
@Table(name = "t_pf_member_award")
@GenericGenerator(name = "jpa-uuid", strategy = "uuid")
@EntityListeners(AuditingEntityListener.class)
public class MemberAward extends BaseEntity{
    @Id
    @GeneratedValue(generator = "jpa-uuid")
    @Column(length = 32)
    private String id;
    private String uid;
    private Integer cpoints; // 此次变更数量
    private Integer tpoints; // 当前总数量
    @Column(name = "awardstatus")
    private String awardStatus="1";
    private String type;// 取枚举值
    @Column(name = "awardtype")
    private String awardType;// 奖励来源1
    @Column(name = "source_type")
    private String sourceType;// 奖励来源2

    private MemberAward(Builder builder) {
        setUid(builder.uid);
        setCpoints(builder.cpoints);
        setTpoints(builder.tpoints);
        setType(builder.type);
        setAwardType(builder.awardType);
        setSourceType(builder.sourceType);
    }

    public enum type {
        integral,exp
    }



    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public Integer getCpoints() {
        return cpoints;
    }

    public void setCpoints(Integer cpoints) {
        this.cpoints = cpoints;
    }

    public Integer getTpoints() {
        return tpoints;
    }

    public void setTpoints(Integer tpoints) {
        this.tpoints = tpoints;
    }

    public String getAwardStatus() {
        return awardStatus;
    }

    public void setAwardStatus(String awardStatus) {
        this.awardStatus = awardStatus;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAwardType() {
        return awardType;
    }

    public void setAwardType(String awardType) {
        this.awardType = awardType;
    }


    public String getSourceType() {
        return sourceType;
    }

    public void setSourceType(String sourceType) {
        this.sourceType = sourceType;
    }

    public static final class Builder {
        private String uid;
        private Integer cpoints;
        private Integer tpoints;
        private String type;
        private String awardType;
        private String sourceType;

        public Builder() {
        }

        public Builder uid(String val) {
            uid = val;
            return this;
        }

        public Builder cpoints(Integer val) {
            cpoints = val;
            return this;
        }

        public Builder tpoints(Integer val) {
            tpoints = val;
            return this;
        }

        public Builder type(String val) {
            type = val;
            return this;
        }

        public Builder awardType(String val) {
            awardType = val;
            return this;
        }

        public Builder sourceType(String val) {
            sourceType = val;
            return this;
        }

        public MemberAward build() {
            return new MemberAward(this);
        }
    }
}
