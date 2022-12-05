package com.codegym.service;

import com.codegym.model.Category;

import java.util.Optional;

public interface ICategoryService {
    Optional<Category> findById(int id);
}
