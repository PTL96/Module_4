package com.castudy.service.impl;

import com.castudy.model.customer.Customer;

import com.castudy.repository.ICustomerRepository;
import com.castudy.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CustomerService implements ICustomerService {
    @Autowired
    ICustomerRepository customerRepository;




    @Override
    public void save(Customer customer) {
        customerRepository.save(customer);
    }

    @Override
    public void deleteSql(Integer deleteId) {
        customerRepository.deleteSql(deleteId);
    }

    @Override
    public Object findById(Integer id) {
        return customerRepository.findById(id);
    }

    @Override
    public Page<Customer> searchPage(Pageable pageable, String names, String email, String customer_type) {
        return customerRepository.searchPage(pageable, names, email, customer_type);
    }

    @Override
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }


}
