package com.webapp.paw2paw.controllers;

import com.webapp.paw2paw.model.OrderHistory;
import com.webapp.paw2paw.repository.OrderRepository;
import com.webapp.paw2paw.repository.UserRepository;
import com.webapp.paw2paw.service.OrderService;
import com.webapp.paw2paw.service.ProductService;
import com.webapp.paw2paw.service.UserProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller

public class buyProductController {

    @Autowired
    private ProductService productService;
    @Autowired
    private OrderRepository orderRepo;
    @Autowired
    private OrderService orderService;
    @Autowired
    private UserProfileService userProfile;
    @Autowired
    private UserRepository userRepo;

/**
    @GetMapping("/buy/{productId}")
    //public ModelAndView exchangeProduct(Model model, @PathVariable("productId") String productId){
       public String showForm(Model model, @PathVariable("productId") String productId){
       model.addAttribute("buy", productService.getProductById(productId));
       String orderProduct = productService.getProductById(productId).getProductName();

       OrderHistory orderHistory = new OrderHistory();
       orderHistory.setOrderItem(orderProduct);
       orderRepo.save(orderHistory);
        // model.addAttribute("orderHistory", orderHistory);
      return "buy";

       /**return new ModelAndView("buy", "submission",
               new OrderHistory(orderProduct, " "," "," "," "));

    }
 **/
    @PostMapping("/save_buy")
    public String exchangeSubmit(Model model,@ModelAttribute ("submission") OrderHistory submission){

         model.addAttribute("buyItem", submission.getOrderItem());
         model.addAttribute("message",submission.getBuyerMessage());
         model.addAttribute("currOrders", orderService);

        return "buy_saved";
    }


    @GetMapping("/buy/{productId}")
    public String orderProduct(Model model, @PathVariable("productId") String productId, String buyerEmail, HttpSession session) {
        model.addAttribute("buy", productService.getProductById(productId));
       // productService.saveProduct(productService.getProductById(productId));
        String orderProduct = productService.getProductById(productId).getProductName();

        OrderHistory orderHistory = new OrderHistory();
        orderHistory.setOrderItem(orderProduct);


        model.addAttribute("currOrder", orderHistory);
      //  model.addAttribute("currOrders", orderService);
        session.setAttribute("currEmail", buyerEmail);
        return "buy";

    }

    @PostMapping("/buy")
    public String newOrder(@ModelAttribute OrderHistory buyOrder, Model model, BindingResult bindingResult, HttpSession session){
        String customerEmail = (String) session.getAttribute("currEmail");
        orderService.addOrder(buyOrder, userRepo.findByEmail(customerEmail));
        model.addAttribute("buyOrder", buyOrder);


        List<OrderHistory> Orders = orderService.getAllOrders();
        model.addAttribute("orders", Orders);


        return "buy_saved";

    }











}
