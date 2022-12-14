package com.castudy.service;

import com.castudy.model.employee.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IEmployeeService {
    Page<Employee> searchPage(Pageable pageable, String names_employee, String phone_number);

    Object findAll();
}
