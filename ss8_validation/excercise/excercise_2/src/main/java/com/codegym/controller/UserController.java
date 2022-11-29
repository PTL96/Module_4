package com.codegym.controller;

import com.codegym.model.User;
import com.codegym.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("")
public class UserController {
    @Autowired
    IUserService userService;

    @GetMapping("/")
    public String userList(Model model) {
        List<User> userList = userService.findAll();
        model.addAttribute("userList", userList);
        return "list";
    }

    @GetMapping("/create")
    public String userCreate(Model model) {
        model.addAttribute("user", new User());
        return "create";
    }

    @PostMapping("/save")
    public String save(@Validated @ModelAttribute User user, BindingResult bindingResult,
                       RedirectAttributes redirectAttributes, Model model){
new User().validate(user, bindingResult);
        if (bindingResult.hasErrors()) {
            return "create";
        }
        userService.save(user);
        redirectAttributes.addFlashAttribute("message","Thêm mới thành công");
        return "redirect:/";
    }

}
