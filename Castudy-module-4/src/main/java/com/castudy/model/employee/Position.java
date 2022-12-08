package com.castudy.model.employee;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Position {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String names;
    @OneToMany(mappedBy = "position")
    private Set<Employee> employees;


}
