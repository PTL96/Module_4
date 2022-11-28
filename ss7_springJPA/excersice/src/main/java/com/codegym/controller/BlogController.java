package com.codegym.controller;

import com.codegym.model.Blog;
import com.codegym.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("")
public class BlogController {
    @Autowired
    IBlogService blogService;

    @GetMapping("/")
    public String blogList(Model model) {
        List<Blog> blogList = blogService.findAll();
        model.addAttribute("blogList", blogList);
        return "list";
    }

    @GetMapping("/create")
    public String createForm(Model model) {
        model.addAttribute("blog", new Blog());
        return "create";
    }

    @GetMapping("/update/{id}")
    public String updateForm(@PathVariable Integer id, Model model) {
        model.addAttribute("blog", blogService.findById(id));
        return "update";
    }

    @GetMapping("/detail")
    public String detail(@RequestParam Integer id) {
        blogService.findById(id);
        return "redirect:/";
    }

    @GetMapping("/search")
    public String search(@RequestParam(defaultValue = "", required = false) String searchName,
                         ModelMap model) {
        List<Blog> blogList = blogService.searchBlog(searchName, searchName);
        model.addAttribute("blogList", blogList);
        return "list";
    }

    @PostMapping("/save")
    public String create(@ModelAttribute Blog blog) {
        blogService.save(blog);
        return "redirect:/";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute Blog blog) {
        blogService.save(blog);
        return "redirect:/";
    }

    @PostMapping("/delete")
    public String delete(@RequestParam Integer deleteId) {
        blogService.delete(deleteId);
        return "redirect:/";
    }
}
