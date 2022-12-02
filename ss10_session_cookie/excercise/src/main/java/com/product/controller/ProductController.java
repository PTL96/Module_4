package com.product.controller;

import com.product.dto.CardDto;
import com.product.dto.ProductDto;
import com.product.model.Product;
import com.product.service.IProductService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;

import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Optional;


@Controller
@RequestMapping("/product")
@SessionAttributes("card")
public class ProductController {
    @ModelAttribute("card")
    public CardDto innitCard(){
        return new CardDto();
    }

    @Autowired
    IProductService productService;

    @GetMapping("")
    public String findAll(Model model){
        List<Product> productList =productService.findAll();
        model.addAttribute("productList",productList);
        return "list";
    }
    @GetMapping("/detail/{id}")
    public ModelAndView detail(@PathVariable int id, HttpServletResponse response){
        Cookie cookie = new Cookie("idProduct", String.valueOf(id));
        cookie.setMaxAge(60);
        cookie.setPath("/");
        response.addCookie(cookie);
        return new ModelAndView("detail","product",productService.findById(id).get());
    }

    @GetMapping("/add/{id}")
    public String addCard(@PathVariable Integer id, @SessionAttribute("card") CardDto cardDto){
        Optional<Product> product = productService.findById(id);
        ProductDto productDto = new ProductDto();
        BeanUtils.copyProperties(product.get(),productDto);
        cardDto.addProduct(productDto);
        return "redirect:/card";
    }
}
