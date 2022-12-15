package com.castudy.controller;

import com.castudy.model.security.User;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.util.WebUtils;

import java.security.Principal;

@Controller
@RequestMapping("/")
public class HomeController {
    @GetMapping("")
    public String home(){
        return "home";
    }
    @GetMapping("/login")
    public String login(){
        return "myLogin/login";
    }

    @GetMapping("/404")
    public String accessDenied() {
        return "security/errors";
        }


    }
