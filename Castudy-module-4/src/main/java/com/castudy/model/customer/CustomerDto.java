package com.castudy.model.customer;


import com.castudy.model.contract.Contract;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import java.util.Set;

public class CustomerDto implements Validator {
    private int id;
    @NotEmpty(message = "Can't be left blank")
    @Pattern(regexp = "^\\p{Lu}\\p{Ll}+(\\s\\p{Lu}\\p{Ll}+)*$", message = "Invalid name !")
    private String names;
    private String dayOfBirth;
    private String gender;
    @NotEmpty(message = "Can't be left blank !")
    @Pattern(regexp = "[0-9]{9}|[0-9]{12}", message = "ID Card invalid !")
    private String idCard;
    @NotEmpty(message = "Can't be left blank !")
    @Pattern(regexp = "[0][0-9]{9}", message = "Invalid name !")
    private String phoneNumber;
    @NotEmpty(message = "Can't be left blank !")
    @Email
    private String email;
    @NotEmpty(message = "Can't be left blank !")
    @Pattern(regexp = "^\\p{Lu}\\p{Ll}+(\\s\\p{Lu}\\p{Ll}+)*$", message = "Address Invalid !")
    private String address;
    @ManyToOne
private CustomerType customerType;
    @OneToMany(mappedBy = "customer")
    private Set<Contract> contracts;

    public CustomerDto() {
    }

    public CustomerDto(int id, @NotEmpty @Pattern(regexp = "^\\p{Lu}\\p{Ll}+(\\s\\p{Lu}\\p{Ll}+)*$", message = "Invalid name !") String names, String dayOfBirth, String gender, @NotEmpty @Pattern(regexp = "[0-9]{9}|[0-9]{12}", message = "ID Card invalid !") String idCard, @NotEmpty @Pattern(regexp = "[0][0-9]{9}") String phoneNumber, @NotEmpty @Email String email, @NotEmpty @Pattern(regexp = "^\\p{Lu}\\p{Ll}+(\\s\\p{Lu}\\p{Ll}+)*$", message = "Address Invalid !") String address, CustomerType customerType, Set<Contract> contracts) {
        this.id = id;
        this.names = names;
        this.dayOfBirth = dayOfBirth;
        this.gender = gender;
        this.idCard = idCard;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.address = address;
        this.customerType = customerType;
        this.contracts = contracts;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNames() {
        return names;
    }

    public void setNames(String names) {
        this.names = names;
    }

    public String getDayOfBirth() {
        return dayOfBirth;
    }

    public void setDayOfBirth(String dayOfBirth) {
        this.dayOfBirth = dayOfBirth;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public CustomerType getCustomerType() {
        return customerType;
    }

    public void setCustomerType(CustomerType customerType) {
        this.customerType = customerType;
    }

    public Set<Contract> getContracts() {
        return contracts;
    }

    public void setContracts(Set<Contract> contracts) {
        this.contracts = contracts;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {

    }
}
