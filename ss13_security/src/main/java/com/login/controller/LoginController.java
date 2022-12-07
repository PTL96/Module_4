//package com.login.controller;
//
//import com.login.model.User;
//import com.login.servise.MyUserDetailService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.Authentication;
//import org.springframework.stereotype.Controller;
//
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.util.WebUtils;
//
//import java.security.Principal;
//
//@Controller
//@RequestMapping("/login")
//public class LoginController {
//    @Autowired
//    MyUserDetailService myUserDetailService;
//    @GetMapping("")
//    public String showForm(){
//        return "login";
//    }
////    @GetMapping("login")
////    public String loginAfter(Model model, Principal principal){
////        String userName = principal.getName();
////
////        System.out.println("User Name: " + userName);
////
////        User user = (User) ((Authentication) principal).getPrincipal();
////
////        String userInfo = WebUtils.toString(user);
////        model.addAttribute("userInfo", user);
////
////        return "loginAfter";
////    }
//}
