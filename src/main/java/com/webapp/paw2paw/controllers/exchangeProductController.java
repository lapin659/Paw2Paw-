package com.webapp.paw2paw.controllers;

import com.webapp.paw2paw.model.OrderHistory;
import com.webapp.paw2paw.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller

public class exchangeProductController {

    @Autowired
    private ProductService productService;
    @Autowired
    private OrderHistory submission;

    @GetMapping("/exchange/{productId}")
    public String exchangeProduct(Model model, @PathVariable("productId") String productId){
       model.addAttribute("exchange", productService.getProductById(productId));
        return "exchange";
    }

    @PostMapping("/save_exchange")
    public String exchangeSubmit(Model model,@ModelAttribute ("submission") OrderHistory submission){
         model.addAttribute("submission", submission);

        System.out.println(submission);
        return "user_profile";
    }

    /**
    @PostMapping("/exchange")
    public String exchangeSubmit(@ModelAttribute OrderHistory submission, Model model){
        model.addAttribute("submission", submission);
        return "exchange"; //has to be exchange to call submission in template exchange.html
    }

**/

}
