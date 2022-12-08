package com.castudy.model.employee;

import javax.persistence.*;
import java.util.Set;

@Entity
public class EducationDegree {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String names;
    @OneToMany(mappedBy = "educationDegree")
    private Set<Employee> employees;
}
