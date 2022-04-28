package com.webapp.paw2paw.controllers;

import com.webapp.paw2paw.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller

public class exchangeProductController {

    @Autowired  private ProductService productService;

    @GetMapping("/exchange/{productId}")
    public String exchangeProduct(Model model, @PathVariable("productId") String productId){
       model.addAttribute("exchange", productService.getProductById(productId));
        return "exchange";
    }




}
