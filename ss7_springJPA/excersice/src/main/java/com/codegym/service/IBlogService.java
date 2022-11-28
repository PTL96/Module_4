package com.codegym.service;

import com.codegym.model.Blog;

import java.util.List;

public interface IBlogService {
    List<Blog> findAll();

    Object findById(Integer id);

    void delete(Integer id);

    void save(Blog blog);

    List<Blog> searchBlog(String searchTitle, String searchAuthor);
}
