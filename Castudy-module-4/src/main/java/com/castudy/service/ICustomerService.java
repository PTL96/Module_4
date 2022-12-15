package com.castudy.service;

import com.castudy.model.customer.Customer;

import org.springframework.data.domain.Page;

import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ICustomerService {


    void save(Customer customer);

    void deleteSql(Integer deleteId);

    Object findById(Integer id);


    Page<Customer> searchPage(Pageable pageable, String names, String email, String customer_type);

    List<Customer> findAll();
}
