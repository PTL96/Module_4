package com.castudy.controller;


import com.castudy.model.contract.Contract;
import com.castudy.model.contract.IContractDto;
import com.castudy.model.customer.Customer;
import com.castudy.model.customer.CustomerDto;
import com.castudy.model.employee.Employee;
import com.castudy.model.facility.Facility;
import com.castudy.service.IContractService;

import com.castudy.service.ICustomerService;
import com.castudy.service.IEmployeeService;
import com.castudy.service.IFacilityService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;


@Controller
@RequestMapping("/contract")
public class ContractController {
    @Autowired
   private IContractService contractService;
    @Autowired
    private IFacilityService facilityService;
    @Autowired
    private ICustomerService customerService;
    @Autowired
    private IEmployeeService employeeService;

    @ModelAttribute("customerList")
   public List<Customer> getCustomerList(){
        return (List<Customer>) customerService.findAll();
    }
    @ModelAttribute("facilityList")
    public List<Facility> getFacilityList(){
        return (List<Facility>) facilityService.findAll();
    }
    @ModelAttribute("employeeList")
    public List<Employee> getEmployeeList(){
        return (List<Employee>) employeeService.findAll();
    }


    @GetMapping("")
    public String showList(@PageableDefault(page = 0, size = 10) Pageable pageable, Model model) {
        Page<IContractDto>iContractDto = contractService.showList(pageable);
        model.addAttribute("contractPage", iContractDto);
        return "contract/list";
    }

    @GetMapping("/create")
    public String create(Model model){
        model.addAttribute("contract", new Contract());
        return "contract/create";
    }

    @GetMapping("/update{id}")
    public String update(@PathVariable Integer id, Model model){
        model.addAttribute("contract", contractService.findById(id));
return "contract/update";
    }


@PostMapping("/save")
    public String save(@ModelAttribute Contract contract){
        contractService.save(contract);
        return "redirect:/contract/";
}

}
