package com.portal.portalspring;

import com.portal.portalspring.repository.MemberRepository;
import com.portal.portalspring.repository.MemoryMemberRepository;
import com.portal.portalspring.service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {

    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }
}
