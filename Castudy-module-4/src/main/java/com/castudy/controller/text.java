package com.castudy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("text")
public class text {

    @GetMapping("")
    public String home (){
        return "contractDetail/list";
    }
}
