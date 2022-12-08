package com.castudy.controller;

import com.castudy.model.facility.Facility;
import com.castudy.service.IFacilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/facility")
public class FacilityController {
    @Autowired
    IFacilityService facilityService;

    @GetMapping("")
    public String showList(Model model) {
        List<Facility> facilityList = facilityService.findAll();
        model.addAttribute("facilityList", facilityList);
        return "facility/list";
    }

    @GetMapping("/create")
    public String save(Model model) {
        model.addAttribute("facilityList", new Facility());
        return "facility/create";
    }

    @GetMapping("/update{id}")
    public String update(@PathVariable Integer id, Model model) {
        model.addAttribute("facility", facilityService.findById(id));
        return ("facility/update");
    }

    @PostMapping("/save")
    public String save(@ModelAttribute Facility facility) {
        facilityService.save(facility);
        return "redirect:/facility/";
    }

}
