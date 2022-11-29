package com.codegym.repository;

import com.codegym.model.TheSong;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ITheSongRepository extends JpaRepository<TheSong, Integer> {
}
