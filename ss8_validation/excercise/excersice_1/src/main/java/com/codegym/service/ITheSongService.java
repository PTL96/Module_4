package com.codegym.service;

import com.codegym.model.TheSong;

import java.util.List;

public interface ITheSongService {
    List<TheSong> findAll();

    Object findById(Integer id);

    void save(TheSong theSong);
}
