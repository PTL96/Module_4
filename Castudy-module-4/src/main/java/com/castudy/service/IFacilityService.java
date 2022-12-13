package com.castudy.service;

import com.castudy.model.facility.Facility;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;


public interface IFacilityService{


    Object findById(Integer id);

    void save(Facility facility);

    void delete(Integer deleteId);

    Page<Facility> searchPage(Pageable pageable, String names, String facility_type);

    List<Facility> findAll();
}
