package com.castudy.model.contract;

import javax.persistence.*;
import java.util.Set;

@Entity
public class AttachFacility {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String names;
    private double cost;
    private String unit;
    private String status;
  @OneToMany(mappedBy = "attachFacility")
    private Set<ContractDetail> contractDetails;
}
