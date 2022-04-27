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
    /**
    @RequestMapping({ "Trading", "Trading/productList","Trading/productList.html"})
    public String listProducts(){
        return "Trading/productList";
    }
     **/

    @Autowired  private ProductService productService;

    @GetMapping("/productList.html")
    public String listProducts(Model model){
        List<Product> listProducts = productService.getAllProducts();
        model.addAttribute("products", listProducts);
        return "productList";
    }

    @GetMapping("/exchange.html")
    public String exchangeProduct(Model model){
        List<Product> exchangeProduct = productService.getAllProducts();
        model.addAttribute("products", exchangeProduct);
        return "exchange";
    }







    /**  public productListController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping ({"/Trading"})
    public String getAllProducts(Model model){
        List<Product> listProducts = productService.getAllProducts();
        model.addAttribute("products",listProducts);
        return "Trading";

} **/






}
