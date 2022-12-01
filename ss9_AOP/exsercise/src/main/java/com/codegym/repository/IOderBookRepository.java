package com.codegym.repository;

import com.codegym.model.OderBook;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IOderBookRepository extends JpaRepository<OderBook, Integer> {
}
