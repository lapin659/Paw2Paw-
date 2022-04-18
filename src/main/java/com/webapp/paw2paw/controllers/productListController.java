package com.webapp.paw2paw.controllers;

import com.webapp.paw2paw.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller

public class productListController {
    @RequestMapping({ "Trading", "Trading/productList","Trading/productList.html"})
   public String listProducts(){
        return "Trading/productList";
    }


private final ProductService productService;

    @Autowired
    public productListController(ProductService productService) {
        this.productService = productService;
    }
/**
    @GetMapping ({"/Trading"})
    public String getAllProducts(Model model){
        List<Product> listProducts = productService.getAllProducts();
        model.addAttribute("products",listProducts);
        return "Trading";

} **/
/**
    @GetMapping("/Trading")
    public String listProducts(Model model){
        List<Product> listProducts = service.listAll();
        model.addAttribute("listProducts", listProducts);
        return "Trading";
    }

**/



}
