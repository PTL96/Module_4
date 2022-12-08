package com.castudy.model.facility;

import com.castudy.model.contract.Contract;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import java.util.Set;


public class FacilityDto implements Validator {
    private int id;
    @NotEmpty(message = "Can't be left blank")
    @Pattern(regexp = "^\\p{Lu}\\p{Ll}+(\\s\\p{Lu}\\p{Ll}+)*$", message = "Invalid name !")
    private String names;
    @NotEmpty(message ="Can't be left blank")
    @Pattern(regexp = "[0-9]{1,5}", message = "Only was input number and max number 5 character")
    private int area;
    @NotEmpty(message ="Can't be left blank")
    @Pattern(regexp = "[0-9]{1,9}", message = "Only was input number and max number 9 character")
    private String cost;
    @NotEmpty(message ="Can't be left blank")
    @Pattern(regexp = "[0-9]{1,2}", message = "Only was input number")
    private int maxPeople;
    @NotEmpty(message = "Can't be left blank")
    @Pattern(regexp = "^\\p{Lu}\\p{Ll}+(\\s\\p{Lu}\\p{Ll}+)*$", message = "Invalid name !")
    private String standardRoom;
    @NotEmpty(message = "Can't be left blank")
    @Pattern(regexp = "^\\p{Lu}\\p{Ll}+(\\s\\p{Lu}\\p{Ll}+)*$", message = "Invalid name !")
    private String otherConvenience;
    @NotEmpty(message ="Can't be left blank")
    @Pattern(regexp = "[0-9]{1,3}", message = "Only was input number and max number 3 character")
    private String poolArea;
    @NotEmpty(message ="Can't be left blank")
    @Pattern(regexp = "[0-9]{1,2}", message = "Only was input number")
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

    public FacilityDto(int id, @NotEmpty(message = "Can't be left blank") @Pattern(regexp = "^\\p{Lu}\\p{Ll}+(\\s\\p{Lu}\\p{Ll}+)*$", message = "Invalid name !") String names, @NotEmpty(message = "Can't be left blank") @Pattern(regexp = "[0-9]{5}", message = "Only was input number and max number 5 character") int area, @NotEmpty(message = "Can't be left blank") @Pattern(regexp = "[0-9]{9}", message = "Only was input number and max number 9 character") String cost, @NotEmpty(message = "Can't be left blank") @Pattern(regexp = "[0-9]", message = "Only was input number") int maxPeople, @NotEmpty(message = "Can't be left blank") @Pattern(regexp = "^\\p{Lu}\\p{Ll}+(\\s\\p{Lu}\\p{Ll}+)*$", message = "Invalid name !") String standardRoom, @NotEmpty(message = "Can't be left blank") @Pattern(regexp = "^\\p{Lu}\\p{Ll}+(\\s\\p{Lu}\\p{Ll}+)*$", message = "Invalid name !") String otherConvenience, @NotEmpty(message = "Can't be left blank") @Pattern(regexp = "[0-9]{3}", message = "Only was input number and max number 3 character") String poolArea, @NotEmpty(message = "Can't be left blank") @Pattern(regexp = "[0-9]", message = "Only was input number") int numberFloors, @NotEmpty(message = "Can't be left blank") String facilityFree, FacilityType facilityType, RentType rentType, Set<Contract> contracts) {
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
