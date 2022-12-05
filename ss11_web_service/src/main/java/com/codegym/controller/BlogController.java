package com.codegym.controller;

import com.codegym.model.Blog;
import com.codegym.service.IBlogService;
import com.codegym.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/blog")
public class BlogController {
    @Autowired
    private IBlogService blogService;
    @Autowired
    private ICategoryService categoryService;

    @GetMapping("")
    public ResponseEntity<List<Blog>> getList(@PageableDefault(page = 0,size = 5) Pageable pageable) {
        Page<Blog> blogList = blogService.findAll(pageable);
        if (blogList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity(blogList,HttpStatus.OK);
    }

    @PostMapping(path = "")
    public ResponseEntity create(@RequestBody Blog blog) {
        blog.setCategory(categoryService.findById(blog.getCategory().getId()));
        blogService.save(blog);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Blog> delete(@PathVariable("id") int id) {
        Blog blog = blogService.findById(id);
        if (blog == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        blogService.delete(id);
        return new ResponseEntity<>(blog, HttpStatus.OK);
    }

    @PutMapping(path = "{id}")
    public ResponseEntity update(@PathVariable("id") int id, @RequestBody Blog blog){
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
