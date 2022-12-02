package com.product.controller;

import com.product.dto.CardDto;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/card")
public class CardController {
    @GetMapping
    public ModelAndView showList(@SessionAttribute("card") CardDto cardDto){
        return new ModelAndView("card-list", "card",cardDto);
    }
}
