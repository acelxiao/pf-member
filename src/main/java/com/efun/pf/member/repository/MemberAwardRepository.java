package com.efun.pf.member.repository;

import com.efun.pf.member.entity.Member;
import com.efun.pf.member.entity.MemberAward;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

/**
 * @author Acel
 * @since 2017/12/25
 */
public interface MemberAwardRepository extends CrudRepository<MemberAward, String> {
}
