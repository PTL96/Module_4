package com.castudy.model.facility;

import com.castudy.model.contract.Contract;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import java.util.Set;


public class FacilityDto implements Validator {
    private int id;
    @NotEmpty(message = "Can't be left blank")
    @Pattern(regexp = "^\\p{Lu}\\p{Ll}+(\\s\\p{Lu}\\p{Ll}+)*$", message = "Invalid name !")
    private String names;

@Max(value = 100000, message = "Input number must be greater than 10 and less than 100000")
@Min(value = 10, message = "Input number must be greater than 10 and less than 100000")
    private int area;

    @NotEmpty(message ="Can't be left blank")
    @Pattern(regexp = "[0-9]{1,9}", message = "Only was input number and max number 9 character")
    private String cost;

@Max(value = 20, message = "Input number must be greater than 1 and less than 20")
@Min(value = 1, message = "Input number must be greater than 1 and less than 20")
    private int maxPeople;

//    @NotEmpty(message = "Can't be left blank")
//    @Pattern(regexp = "^\\p{Lu}\\p{Ll}+(\\s\\p{Lu}\\p{Ll}+)*$", message = "Invalid name !")
    private String standardRoom;

    @NotEmpty(message = "Can't be left blank")
    @Pattern(regexp = "^\\p{Lu}\\p{Ll}+(\\s\\p{Lu}\\p{Ll}+)*$", message = "Invalid name !")
    private String otherConvenience;

    @Max(value = 2000, message = "Input number must be greater than 1 and less than 2000")
    private String poolArea;

    @Max(value = 5, message = "Input number must be greater than 1 and less than 5")
    @Min(value = 1, message = "Input number must be greater than 1 and less than 5")
    private int numberFloors;

    @NotEmpty(message ="Can't be left blank")
    private String facilityFree;

    @ManyToOne
    private FacilityType facilityType;
    @ManyToOne
    private RentType rentType;
    @OneToMany(mappedBy = "facility")
    private Set<Contract> contracts;

    public FacilityDto() {
    }

    public FacilityDto(int id, @NotEmpty(message = "Can't be left blank") @Pattern(regexp = "^\\p{Lu}\\p{Ll}+(\\s\\p{Lu}\\p{Ll}+)*$", message = "Invalid name !") String names, @Max(value = 100000, message = "Input number must be greater than 10 and less than 100000") @Min(value = 10, message = "Input number must be greater than 10 and less than 100000") int area, @NotEmpty(message = "Can't be left blank") @Pattern(regexp = "[0-9]{1,9}", message = "Only was input number and max number 9 character") String cost, @Max(value = 20, message = "Input number must be greater than 1 and less than 20") @Min(value = 1, message = "Input number must be greater than 1 and less than 20") int maxPeople, String standardRoom, @NotEmpty(message = "Can't be left blank") @Pattern(regexp = "^\\p{Lu}\\p{Ll}+(\\s\\p{Lu}\\p{Ll}+)*$", message = "Invalid name !") String otherConvenience, @Max(value = 2000, message = "Input number must be greater than 1 and less than 2000") @Min(value = 1, message = "Input number must be greater than 1 and less than 2000") String poolArea, @Max(value = 5, message = "Input number must be greater than 1 and less than 5") @Min(value = 1, message = "Input number must be greater than 1 and less than 5") int numberFloors, @NotEmpty(message = "Can't be left blank") String facilityFree, FacilityType facilityType, RentType rentType, Set<Contract> contracts) {
        this.id = id;
        this.names = names;
        this.area = area;
        this.cost = cost;
        this.maxPeople = maxPeople;
        this.standardRoom = standardRoom;
        this.otherConvenience = otherConvenience;
        this.poolArea = poolArea;
        this.numberFloors = numberFloors;
        this.facilityFree = facilityFree;
        this.facilityType = facilityType;
        this.rentType = rentType;
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

    public int getArea() {
        return area;
    }

    public void setArea(int area) {
        this.area = area;
    }

    public String getCost() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }

    public int getMaxPeople() {
        return maxPeople;
    }

    public void setMaxPeople(int maxPeople) {
        this.maxPeople = maxPeople;
    }

    public String getStandardRoom() {
        return standardRoom;
    }

    public void setStandardRoom(String standardRoom) {
        this.standardRoom = standardRoom;
    }

    public String getOtherConvenience() {
        return otherConvenience;
    }

    public void setOtherConvenience(String otherConvenience) {
        this.otherConvenience = otherConvenience;
    }

    public String getPoolArea() {
        return poolArea;
    }

    public void setPoolArea(String poolArea) {
        this.poolArea = poolArea;
    }

    public int getNumberFloors() {
        return numberFloors;
    }

    public void setNumberFloors(int numberFloors) {
        this.numberFloors = numberFloors;
    }

    public String getFacilityFree() {
        return facilityFree;
    }

    public void setFacilityFree(String facilityFree) {
        this.facilityFree = facilityFree;
    }

    public FacilityType getFacilityType() {
        return facilityType;
    }

    public void setFacilityType(FacilityType facilityType) {
        this.facilityType = facilityType;
    }

    public RentType getRentType() {
        return rentType;
    }

    public void setRentType(RentType rentType) {
        this.rentType = rentType;
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
