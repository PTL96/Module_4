package com.castudy.service;

import com.castudy.model.customer.Customer;

import org.springframework.data.domain.Page;

import org.springframework.data.domain.Pageable;

public interface ICustomerService {
    Page<Customer> findAll(Pageable pageable);


    void save(Customer customer);

    void delete(Integer deleteId);

    Object findById(Integer id);


    Page<Customer> searchPage(Pageable pageable, String names, String email, String customer_type);
}
