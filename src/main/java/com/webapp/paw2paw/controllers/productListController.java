package com.webapp.paw2paw.controllers;

import com.webapp.paw2paw.model.Product;
import com.webapp.paw2paw.repository.OrderRepository;
import com.webapp.paw2paw.repository.UserRepository;
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
    private UserRepository userRepo;
    private OrderRepository orderRepo;

    @GetMapping("/productList.html")
    public String listProducts(Model model){
        List<Product> listProducts = productService.getAllProducts();
        model.addAttribute("products", listProducts);

        List<Product> secondListProducts = productService.getSecondProducts();
        model.addAttribute("productsB", secondListProducts);
        return "productList";
    }

    /**
    @GetMapping("productList/{userId}")
    public String startOrder(@PathVariable String userId, Model model, Principal principal,
                             HttpServletRequest request){
        if(!principal.getName().isEmpty()) {
            String userEmail= principal.getName();
            User currUser = userRepo.findByEmail(userEmail);
            userRepo.save(currUser);

            model.addAttribute("currUser", currUser);
            model.addAttribute("userId", userId);

            List<Product> listProducts = productService.getAllProducts();
            model.addAttribute("products", listProducts);
        }else{
            model.addAttribute("newUser", new User());
        }

        String contextPath = request.getContextPath();

        return contextPath + "productList" + '/' + userId;

    }


    @PostMapping("productList/{id}")
    public RedirectView updateOrder(@RequestParam String order_Id, HttpServletRequest request) {
        String contextPath = request.getContextPath();
        return new RedirectView(contextPath + "/user_profile/" + order_Id);
    }


**/






}
