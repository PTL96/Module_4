package com.castudy.repository;

import com.castudy.model.contract.Contract;
import com.castudy.model.contract.IContractDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface IContractRepository extends JpaRepository<Contract,Integer> {
    @Query(value= "SELECT contract.star_day as starDay, contract.end_day as endDay, contract.deposit as deposit, employee.names as employee,customer.names as customer,facility.names as facility,\n" +
            "sum((ifnull(contract_detail.quantity,0) * ifnull(attach_facility.cost,0)) + facility.cost) AS totalAmount \n" +
            "FROM contract\n" +
            "LEFT JOIN employee on employee.id = contract.employee_id\n" +
            "LEFT JOIN customer on customer.id=contract.customer_id\n" +
            "LEFT JOIN facility on facility.id = contract.facility_id\n" +
            "LEFT JOIN contract_detail on contract_detail.contract_id=contract.id\n" +
            "LEFT JOIN attach_facility on attach_facility.id=contract_detail.attach_facility_id\n" +
            "group by contract.id\n" +
            "order by contract.id"
            ,countQuery="select * from(SELECT contract.star_day as starDay, contract.end_day as endDay, contract.deposit as deposit, employee.names as employee,customer.names as customer,facility.names as facility,\n" +
            "sum((ifnull(contract_detail.quantity,0) * ifnull(attach_facility.cost,0)) + facility.cost) AS totalAmount \n" +
            "FROM contract\n" +
            "LEFT JOIN employee on employee.id = contract.employee_id\n" +
            "LEFT JOIN customer on customer.id=contract.customer_id\n" +
            "LEFT JOIN facility on facility.id = contract.facility_id\n" +
            "LEFT JOIN contract_detail on contract_detail.contract_id=contract.id\n" +
            "LEFT JOIN attach_facility on attach_facility.id=contract_detail.attach_facility_id\n" +
            "group by contract.id\n" +
            "order by contract.id) as contractView"
            , nativeQuery= true)
    Page<IContractDto> showList(Pageable pageable);

}
