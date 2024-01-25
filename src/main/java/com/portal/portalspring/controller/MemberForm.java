package com.portal.portalspring.controller;

public class MemberForm {
    private String name;
    private Long regId;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getRegId() {
        return regId;
    }

    public void setRegId(Long regId) {
        this.regId = regId;
    }
}
