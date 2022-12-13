package com.castudy.controller;

import com.castudy.model.facility.Facility;
import com.castudy.model.facility.FacilityDto;
import com.castudy.service.IFacilityService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/facility")
public class FacilityController {

    @Autowired
    IFacilityService facilityService;


    @GetMapping("")
    public String showList(@PageableDefault(page = 0, size = 10) Pageable pageable,
                           @RequestParam(required = false, defaultValue = "") String names,
                           @RequestParam(required = false, defaultValue = "") String facility_type, Model model) {
        Page<Facility> facilityPage = facilityService.searchPage(pageable, names, facility_type);
        model.addAttribute("facilityPage", facilityPage);

        return "facility/list";
    }

    @GetMapping("/create")
    public String createForm(Model model) {
        model.addAttribute("facilityDto", new FacilityDto());
        return "facility/create";
    }

    @GetMapping("/update{id}")
    public String update(@PathVariable Integer id, FacilityDto facilityDto, Model model) {
        model.addAttribute("facility", facilityService.findById(id));
        Facility facility = new Facility();
        BeanUtils.copyProperties(facilityDto, facility);
        return "facility/update";
    }

    @PostMapping("/save")
    public String save(@Validated @ModelAttribute FacilityDto facilityDto, BindingResult bindingResult, Model model) {
        new FacilityDto().validate(facilityDto, bindingResult);
        if (bindingResult.hasFieldErrors()) {
            return "facility/create";
        } else {
            Facility facility = new Facility();
            BeanUtils.copyProperties(facilityDto, facility);
            facilityService.save(facility);
            model.addAttribute("mess", " Create Facility new successfully");
            return "redirect:/facility/";
        }
    }

    @PostMapping("/delete")
    public String delete(@RequestParam Integer deleteId) {
        facilityService.delete(deleteId);
        return "redirect:/facility/";
    }
}
