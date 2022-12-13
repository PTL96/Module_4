package com.castudy.service.impl;


import com.castudy.model.contract.Contract;
import com.castudy.model.contract.IContractDto;
import com.castudy.repository.IContractRepository;
import com.castudy.service.IContractService;
import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContractService implements IContractService {
    @Autowired
    IContractRepository contractRepository;

    @Override
    public Object findById(Integer id) {
        return contractRepository.findById(id);
    }

    @Override
    public Page<IContractDto> showList(Pageable pageable) {
        return contractRepository.showList(pageable);
    }

    @Override
    public void save(Contract contract) {
        contractRepository.save(contract);
    }

    @Override
    public List<Contract> findAll() {
        return contractRepository.findAll();
    }
}
