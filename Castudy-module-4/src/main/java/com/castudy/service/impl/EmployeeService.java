package com.castudy.service.impl;

import com.castudy.model.employee.Employee;
import com.castudy.repository.IEmployeeRepository;
import com.castudy.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService implements IEmployeeService {
    @Autowired
    IEmployeeRepository employeeRepository;
    @Override
    public Page<Employee> searchPage(Pageable pageable, String names_employee, String phone_number) {
        return employeeRepository.searchPage(pageable,names_employee,phone_number);
    }

    @Override
    public Object findAll() {
        return employeeRepository.findAll();
    }
}
