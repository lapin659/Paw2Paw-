package com.webapp.paw2paw.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class productListController {
    @RequestMapping({"/Trading", "/Trading/productList", "/Trading/productList.html"})
    public String listProducts(){
        return "Trading/productList";
    }
}
