package com.portal.portalspring;

import com.portal.portalspring.repository.JdbcMemberRepository;
import com.portal.portalspring.repository.JdbcTemplateMemberRepository;
import com.portal.portalspring.repository.MemberRepository;
import com.portal.portalspring.repository.MemoryMemberRepository;
import com.portal.portalspring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class SpringConfig {

    private DataSource dataSource;

    @Autowired
    public SpringConfig(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
//        return new MemoryMemberRepository();
//        return new JdbcMemberRepository(dataSource);
        return new JdbcTemplateMemberRepository(dataSource);
    }

}
