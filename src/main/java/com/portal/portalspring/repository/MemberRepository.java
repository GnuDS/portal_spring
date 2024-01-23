package com.portal.portalspring.repository;

import com.portal.portalspring.domain.Member;

import java.util.List;
import java.util.Optional;

// 인터페이스
public interface MemberRepository {
    Member save(Member member);
    // 파라미터가 Null경우를 대비하여 Optional을 사용
    Optional<Member> findById(Long id);
    Optional<Member> findByName(String name);
    List<Member> findAll();
}
