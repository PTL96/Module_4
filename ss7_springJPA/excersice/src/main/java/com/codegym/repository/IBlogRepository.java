package com.codegym.repository;

import com.codegym.model.Blog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IBlogRepository extends JpaRepository <Blog, Integer> {
    @Query(value = "select * from blog b where b.author like CONCAT('%',:author,'%') or b.title like CONCAT('%',:title,'%')", nativeQuery = true)
    List<Blog> searchBlog(@Param("author") String author, @Param("title") String title);
}
