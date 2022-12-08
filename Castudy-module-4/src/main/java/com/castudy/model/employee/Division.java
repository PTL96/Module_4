package com.castudy.model.employee;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Division {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String names;
    @OneToMany(mappedBy = "division")
    private Set<Employee> employees;

}
