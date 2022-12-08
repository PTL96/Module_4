package com.castudy.controller;

import com.castudy.model.customer.Customer;
import com.castudy.model.customer.CustomerDto;
import com.castudy.service.ICustomerService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/customer")

public class CustomerController {
    @Autowired
    ICustomerService customerService;

    @GetMapping("")
    public String showList(@PageableDefault(page = 0, size = 5) Pageable pageable,
                           @RequestParam(required = false, defaultValue = "") String names,
                           @RequestParam(required = false, defaultValue = "") String email,
                           @RequestParam(required = false, defaultValue = "") String customer_type, Model model) {
        Page<Customer> customerPage = customerService.searchPage(pageable, names, email, customer_type);
        model.addAttribute("customerPage", customerPage);
        return "customer/list";
    }

    @GetMapping("/create")
    public String createForm(Model model) {
        model.addAttribute("customerDto", new CustomerDto());
        return "customer/create";
    }

    @GetMapping("/update{id}")
    public String update(@PathVariable Integer id, CustomerDto customerDto, Model model) {
        model.addAttribute("customer", customerService.findById(id));
        Customer customer = new Customer();
        BeanUtils.copyProperties(customerDto, customer);
        return "customer/update";
    }


    @PostMapping("/save")
    public String save(@Validated @ModelAttribute CustomerDto customerDto, BindingResult bindingResult, Model model) {
        new CustomerDto().validate(customerDto, bindingResult);
        if (bindingResult.hasFieldErrors()) {
            return "customer/create";
        } else {
            Customer customer = new Customer();
            BeanUtils.copyProperties(customerDto, customer);
            customerService.save(customer);
            model.addAttribute("mess", " Create Customer new successfully");
            return "redirect:/customer/";
        }
    }

    @PostMapping("/delete")
    public String delete(@RequestParam Integer deleteId) {
        customerService.delete(deleteId);
        return "redirect:/customer/";
    }

    @PostMapping("/update")
    public String edit(@Validated @ModelAttribute(value = "customer") CustomerDto customerDto, BindingResult bindingResult, Model model) {

        new CustomerDto().validate(customerDto, bindingResult);
        if (bindingResult.hasFieldErrors()) {
            return "customer/update";
        } else {
            Customer customer = new Customer();
            BeanUtils.copyProperties(customerDto, customer);
            customerService.save(customer);
            model.addAttribute("mess", " Update Customer successfully");
            return "redirect:/customer/";
        }
    }
}