package com.castudy.repository;

import com.castudy.model.facility.Facility;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface IFacilityRepository extends JpaRepository<Facility, Integer> {
    @Query(value="select * from furama.facility where names like %:names% and facility_type_id like %:facility_type% ", nativeQuery=true)
    Page<Facility> searchPage(Pageable pageable, @Param("names") String names, @Param("facility_type") String facility_type);

}
