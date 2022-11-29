package com.codegym.service;

import com.codegym.model.TheSong;
import com.codegym.repository.ITheSongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class TheSongService implements ITheSongService {
    @Autowired
    private ITheSongRepository theSongRepository;

    @Override
    public List<TheSong> findAll() {
        return theSongRepository.findAll();
    }

    @Override
    public Object findById(Integer id) {
        return theSongRepository.findById(id);
    }

    @Override
    public void save(TheSong theSong) {
        theSongRepository.save(theSong);
    }
}
