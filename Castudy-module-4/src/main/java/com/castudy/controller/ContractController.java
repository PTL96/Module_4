package com.castudy.controller;


import com.castudy.model.contract.Contract;
import com.castudy.model.contract.IContractDto;
import com.castudy.model.customer.Customer;
import com.castudy.model.facility.Facility;
import com.castudy.service.IContractService;

import com.castudy.service.ICustomerService;
import com.castudy.service.IFacilityService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;





@Controller
@RequestMapping("/contract")
public class ContractController {
    @Autowired
   private IContractService contractService;

//
//    @GetMapping("contract")
//    public String modelAndView(Model model, ModelMap modelMap){
//        ModelAndView modelAndView = new ModelAndView("contract/create");
//        List<Facility> facilityList = facilityService.findAll();
//        List<Customer> customerList = customerService.findAll();
//        List<Contract> contractList = contractService.findAll();
//        modelAndView.addObject("facilityList", facilityList);
//        modelAndView.addObject("customerList",customerList);
//        modelAndView.addObject("contractList", contractList);
//
//        return "";
//    }


    @GetMapping("")
    public String showList(@PageableDefault(page = 0, size = 10) Pageable pageable, Model model) {
        Page<IContractDto>iContractDto = contractService.showList(pageable);
        model.addAttribute("contractPage", iContractDto);
        return "contract/list";
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
