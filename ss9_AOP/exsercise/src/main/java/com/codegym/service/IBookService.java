package com.codegym.service;

import com.codegym.model.Book;

import java.util.List;

public interface IBookService {
    List<Book> findAll();

    Object findById(int id);

    void saveBook(Book book);
}
