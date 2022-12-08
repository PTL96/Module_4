package com.castudy.model.contract;

import com.castudy.model.customer.Customer;

import com.castudy.model.employee.Employee;
import com.castudy.model.facility.Facility;

import javax.persistence.*;
import java.util.Set;


@Entity
public class Contract {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String starDay;
    private String endDay;
    private double deposit;
    @ManyToOne
    private Facility facility;

    @ManyToOne
private Customer customer;
    @OneToMany(mappedBy = "contract")
    private Set<ContractDetail> contractDetails;
@ManyToOne
    private Employee employee;
}
