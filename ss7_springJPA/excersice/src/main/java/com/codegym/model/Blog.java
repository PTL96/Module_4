package com.codegym.model;

import javax.persistence.*;

@Entity
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String title;
    private String content;
    private String author;
    private String starDay;
    @ManyToOne
    private Category category;
    public Category getCategory(){
        return category;
    }
public void setCategory(Category category){
        this.category = category;
}
    public Blog() {
    }

    public Blog(Integer id, String title, String content, String author, String starDay, Category category) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.author = author;
        this.starDay = starDay;
        this.category = category;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getStarDay() {
        return starDay;
    }

    public void setStarDay(String starDay) {
        this.starDay = starDay;
    }
}
