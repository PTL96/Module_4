package com.codegym.service;

import com.codegym.model.OderBook;

import java.util.List;

public interface IOderBookService {
    List<OderBook> findAll();

    void saveOder(OderBook oderBook);

    OderBook findByBookRentalCode(long bookRentalCode);
}
