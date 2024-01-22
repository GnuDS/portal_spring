package com.portal.portalspring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PortalController {

    @GetMapping("portal")
    public String portal(
            @RequestParam(value="name", required=false) String name,
            Model model
    ) {
        model.addAttribute("name", name);
        model.addAttribute("data","portal");
        return "portal";
    }

    @GetMapping("portal-data")
    @ResponseBody
    public String portalData(
            @RequestParam(value="name", required=false) String name
    ) {
        return "hello " + name;
    }

    @GetMapping("portal-api")
    @ResponseBody
    public Portal portalApi(@RequestParam(value="name", required=false) String name) {
        Portal portal = new Portal();
        portal.setName(name);
        return portal;
    }

    static class Portal {
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

}
