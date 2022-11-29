package com.codegym.controller;

import com.codegym.model.TheSong;
import com.codegym.service.ITheSongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("")
public class TheSongController {
    @Autowired
    ITheSongService theSongService;

    @GetMapping("/")
    public String songList(Model model) {
        List<TheSong> theSongList = theSongService.findAll();
        model.addAttribute("theSongList", theSongList);
        return "list";
    }

    @GetMapping("/create")
    public String createForm(Model model) {
        model.addAttribute("theSong", new TheSong());
        return "create";
    }

    @GetMapping("/update{id}")
    public String updateForm(@PathVariable Integer id, Model model) {
        model.addAttribute("theSong", theSongService.findById(id));
        return "update";
    }


    @PostMapping("/save")
    public String create(@Valid @ModelAttribute TheSong theSong, BindingResult bindingResult, RedirectAttributes redirectAttributes, Model model) {
        new TheSong().validate(theSong, bindingResult);
        if (bindingResult.hasErrors()) {
            return "create";
        }
        theSongService.save(theSong);
        redirectAttributes.addFlashAttribute("message","Thêm mới thành công");
        return "redirect:/";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute TheSong theSong) {
        theSongService.save(theSong);
        return "redirect:/";
    }
}
