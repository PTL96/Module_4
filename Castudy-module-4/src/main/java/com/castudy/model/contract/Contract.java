package com.castudy.model.contract;

import com.castudy.model.customer.Customer;

import com.castudy.model.employee.Employee;
import com.castudy.model.facility.Facility;
import com.fasterxml.jackson.annotation.JsonBackReference;

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
    @JsonBackReference
    private Facility facility;

    @ManyToOne
    @JsonBackReference
private Customer customer;
    @OneToMany(mappedBy = "contract")

    @JsonBackReference
    private Set<ContractDetail> contractDetails;

@ManyToOne
@JsonBackReference
    private Employee employee;

    public Contract() {
    }

    public Contract(int id, String starDay, String endDay, double deposit, Facility facility, Customer customer, Set<ContractDetail> contractDetails, Employee employee) {
        this.id = id;
        this.starDay = starDay;
        this.endDay = endDay;
        this.deposit = deposit;
        this.facility = facility;
        this.customer = customer;
        this.contractDetails = contractDetails;
        this.employee = employee;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStarDay() {
        return starDay;
    }

    public void setStarDay(String starDay) {
        this.starDay = starDay;
    }

    public String getEndDay() {
        return endDay;
    }

    public void setEndDay(String endDay) {
        this.endDay = endDay;
    }

    public double getDeposit() {
        return deposit;
    }

    public void setDeposit(double deposit) {
        this.deposit = deposit;
    }

    public Facility getFacility() {
        return facility;
    }

    public void setFacility(Facility facility) {
        this.facility = facility;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Set<ContractDetail> getContractDetails() {
        return contractDetails;
    }

    public void setContractDetails(Set<ContractDetail> contractDetails) {
        this.contractDetails = contractDetails;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}

