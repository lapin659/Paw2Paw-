package com.webapp.paw2paw.controllers;

import com.webapp.paw2paw.model.Product;
import com.webapp.paw2paw.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller

public class productListController {

    @Autowired
    private ProductService productService;

    @GetMapping("/productList.html")
    public String listProducts(Model model){
        List<Product> listProducts = productService.getAllProducts();
        model.addAttribute("products", listProducts);
        return "productList";
    }





/**
    @GetMapping("/{productId}")
    public String exchangeProduct(Model model, @PathVariable("productId") String productId){
       model.addAttribute("exchange", productService.getProductById(productId));
        return "exchange";
    }
**/



}
