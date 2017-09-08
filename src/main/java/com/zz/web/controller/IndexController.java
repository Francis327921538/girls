package com.zz.web.controller;

import javax.servlet.http.HttpSession;

import lombok.extern.java.Log;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Log
public class IndexController {

    @GetMapping(value = {"", "/"})
    public String index(org.springframework.ui.Model model) {
        model.addAttribute("name", "zz");
        return "index";
    }

    @GetMapping(value = "/login")
    public String loginView() {
        return "login";
    }


    /***************USER_MODULE****************/
    @GetMapping("/user")
    public String user() {
        return "admin/user/list";
    }
    /***************USER_MODULE****************/

    /***************ROlE_MODULE****************/
    @GetMapping("/role")
    public String role() {
        return "admin/role/list";
    }
    /***************ROlE_MODULE****************/

    /***************ROlE_MODULE****************/
    @GetMapping("/chat")
    public String chat() {
        return "admin/notification/chat";
    }
    /***************ROlE_MODULE****************/


    @GetMapping("/dologout")
    public void logout(HttpSession session) {
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
    }

}
