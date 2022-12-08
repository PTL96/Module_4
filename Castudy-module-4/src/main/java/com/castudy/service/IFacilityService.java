package com.castudy.service;

import com.castudy.model.facility.Facility;

import java.util.List;

public interface IFacilityService{
    List<Facility> findAll();

    Object findById(Integer id);

    void save(Facility facility);
}
