package com.efun.pf.member.repository;

import com.efun.pf.member.entity.Member;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

/**
 * @author Acel
 * @since 2017/12/25
 */
public interface MemberRepository extends CrudRepository<Member, String> {
    Member findByUid(String uid);

    @Modifying
    @Query("update Member set modifiedTime = now(), goldValue = goldValue + ?1 where uid = ?2")
    int addGoldValue(int goldValue, String uid);
}
