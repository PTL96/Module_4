package com.castudy.model.contract;

import javax.persistence.*;


@Entity
public class ContractDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int quantity;
    @ManyToOne
    private Contract contract;
    @ManyToOne
    private AttachFacility attachFacility;
}
