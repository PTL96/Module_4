package com.codegym.repository;

import com.codegym.model.Blog;
import com.codegym.model.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface IBlogRepository extends JpaRepository<Blog,Integer> {
    List<Blog> findByCategory(Category category);
    Page<Blog> findAll(Pageable pageable);
    Page<Blog> findBlogByTitleContaining(String searchKey ,Pageable pageable);
}
