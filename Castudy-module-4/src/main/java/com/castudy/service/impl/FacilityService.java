package com.castudy.service.impl;

import com.castudy.model.facility.Facility;
import com.castudy.repository.IFacilityRepository;
import com.castudy.service.IFacilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;



@Service
public class FacilityService implements IFacilityService {
    @Autowired
    IFacilityRepository facilityRepository;

    @Override
    public Object findById(Integer id) {
        return facilityRepository.findById(id);
    }

    @Override
    public void save(Facility facility) {
        facilityRepository.save(facility);
    }

    @Override
    public void delete(Integer deleteId) {
        facilityRepository.deleteById(deleteId);
    }

    @Override
    public Page<Facility> searchPage(Pageable pageable, String names, String facility_type) {
        return facilityRepository.searchPage(pageable,names,facility_type);
    }
}
