package com.portal.portalspring.service;

import com.portal.portalspring.domain.Member;
import com.portal.portalspring.repository.MemberRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * 통합 테스트
 */
@SpringBootTest
@Transactional
class MemberServiceIntegrationTest {

    @Autowired MemberService memberService;
    @Autowired MemberRepository memberRepository;

    @Test
    void 회원가입() {

        long start = System.currentTimeMillis();

        // given
        Member member = new Member();
        member.setName("spring3");

        // when
        Long saveId = memberService.join(member);

        // then
        Member findMember = memberService.findOne(saveId).get();
        assertThat(member.getName()).isEqualTo(findMember.getName());

        long finish = System.currentTimeMillis();
        long timestamp = finish - start;

        System.out.println("join " + timestamp + " ms");

    }

    @Test
    void 중복_회원_예회() {
        // given
        Member member = new Member();
        member.setName("spring4");
        Member member2 = new Member();
        member2.setName("spring4");

        // when
        memberService.join(member);
//        memberService.join(member2);
        IllegalStateException e = assertThrows(IllegalStateException.class, () -> memberService.join(member2));
        assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");
        // then
    }
}