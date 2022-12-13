package com.castudy.controller;

import com.castudy.model.contract.ContractDetail;
import com.castudy.service.IContractDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("contractDetail")
public class ContractDetailController {
    @Autowired
    private IContractDetailService iContractDetailService;


    @GetMapping("")
    public ResponseEntity<List<ContractDetail>> getList(){
        List<ContractDetail> contractDetailList = iContractDetailService.findAll();
        if (contractDetailList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(contractDetailList,HttpStatus.OK);
    }
}
