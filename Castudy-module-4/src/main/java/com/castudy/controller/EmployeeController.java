package com.castudy.controller;

import com.castudy.model.contract.Contract;
import com.castudy.model.employee.Employee;
import com.castudy.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
  private IEmployeeService employeeService;
    @GetMapping("")
    public String showList(@PageableDefault(page = 0, size = 10)Pageable pageable,
                           @RequestParam(required = false, defaultValue = "") String names_employee,
                           @RequestParam(required = false, defaultValue = "") String phone_number, Model model) {
        Page<Employee> employeePage = employeeService.searchPage(pageable, names_employee, phone_number);
        model.addAttribute("employeePage", employeePage);
        return "employee/list";

    }
}
