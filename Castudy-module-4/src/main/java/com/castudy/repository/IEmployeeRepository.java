package com.castudy.repository;


import com.castudy.model.employee.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;



public interface IEmployeeRepository extends JpaRepository<Employee, Integer> {
    @Query(value="select * from furama.employee  where names like %:names_employee% and phone_number like %:phone_number% order by names ", nativeQuery=true)
    Page<Employee> searchPage(Pageable pageable, @Param("names_employee") String names_employee, @Param("phone_number") String phone_number);
}
