package com.castudy.service;


import com.castudy.model.contract.Contract;
import com.castudy.model.contract.IContractDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IContractService {
    


    Object findById(Integer id);

    Page<IContractDto> showList(Pageable pageable);

    void save(Contract contract);

    List<Contract> findAll();
}
