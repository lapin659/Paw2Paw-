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
import org.springframework.web.servlet.ModelAndView;

@Controller

public class buyProductController {

    @Autowired
    private ProductService productService;


    @GetMapping("/buy/{productId}")
    //public ModelAndView exchangeProduct(Model model, @PathVariable("productId") String productId){
       public ModelAndView showForm(Model model, @PathVariable("productId") String productId){
       model.addAttribute("buy", productService.getProductById(productId));
       String orderProduct = productService.getProductById(productId).getProductName();

       OrderHistory orderHistory = new OrderHistory(orderProduct,"","" );
       model.addAttribute("orderHistory", orderHistory);
       //return "buy";

       return new ModelAndView("buy", "submission",
               new OrderHistory(orderProduct, " "," "));

    }

    @PostMapping("/save_buy")
    public String exchangeSubmit(Model model,@ModelAttribute ("submission") OrderHistory submission){
         model.addAttribute("buyItem", submission.getExchangeItem());
         model.addAttribute("message",submission.getBuyerMessage());

        return "buy_saved";
    }

    /**
    @PostMapping("/exchange")
    public String exchangeSubmit(@ModelAttribute OrderHistory submission, Model model){
        model.addAttribute("submission", submission);
        return "exchange"; //has to be exchange to call submission in template exchange.html
    }

**/

}
