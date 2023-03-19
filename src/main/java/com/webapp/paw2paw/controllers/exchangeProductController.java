package com.webapp.paw2paw.controllers;

import com.webapp.paw2paw.model.OrderHistory;
import com.webapp.paw2paw.model.Product;
import com.webapp.paw2paw.model.User;
import com.webapp.paw2paw.repository.OrderRepository;
import com.webapp.paw2paw.repository.UserRepository;
import com.webapp.paw2paw.service.OrderService;
import com.webapp.paw2paw.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class exchangeProductController {

    @Autowired
    private ProductService prodService;
    @Autowired
    private OrderService odrService;

    @Autowired
    private UserRepository usrRepo;
    @Autowired
    private OrderRepository orderRepo;
/**
    @PostMapping("/save_exchange")
    public String exSubmit(Model model,@ModelAttribute ("sub") OrderHistory savedExchange){

        model.addAttribute("exchItem", savedExchange.getOrderItem());
        model.addAttribute("exchMessage",savedExchange.getBuyerMessage());
        model.addAttribute("currExchange", odrService);

        return "exchange_saved";
    }**/

    @GetMapping("/exchange/{productId}")
    public String exchangeProduct(Model model, @PathVariable("productId") String productId,
                                  String exchangeEmail, HttpSession session){
        model.addAttribute("exchange", prodService.getProductById(productId));
        Product currProduct = prodService.getProductById(productId);
        String exchangeProduct = prodService.getProductById(productId).getProductName();
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userEmail = authentication.getName();
        User currUser = usrRepo.findByEmail(userEmail);
        Long userId = currUser.getId();

        OrderHistory orderHistory = new OrderHistory();
        orderHistory.setOrderItem(exchangeProduct); //changed
        orderHistory.setUser(currUser);
        orderHistory.setOrderId(Long.parseLong(productId));
        orderHistory.setExchangeItem(currProduct.getDescription());

        orderRepo.save(orderHistory);
        usrRepo.save(currUser);

        model.addAttribute("currUser", currUser);
        model.addAttribute("userId", userId);
        model.addAttribute("exchangeProduct", exchangeProduct);
        model.addAttribute("currOrder", orderHistory);
        session.setAttribute("currEmail", exchangeEmail);



        /**
        String exchangeProduct = prodService.getProductById(productId).getProductName();
        model.addAttribute("exchangeProduct", exchangeProduct);
        List<OrderHistory> allOrders = odrService.getAllOrders();
        OrderHistory exchangeHistory = odrService.getOrderByName(exchangeProduct);
        **/

        //add product info into new orderhistory object
        //pass to post "saved" page
        /**
        OrderHistory exchangeHistory = new OrderHistory();
        exchangeHistory.getOrderedProduct(productId);
        model.addAttribute("productId", productId);
         **/
       // orderRepos.save(exchangeHistory);

      //  sess.setAttribute("ExchangeEmail",exchangeEmail);
          return "exchange";
    }
         /**
    @GetMapping("/exchange_saved/{productId}")
    public String showExchanged(@PathVariable("productId") String productId, Model model){
        Product exchange = prodService.getProductById(productId);
        model.addAttribute("exchange", exchange);
        return "exchange_saved";

    }

          **/



    @PostMapping( "/exchange")
    public String addExchangeOrder(@ModelAttribute("exchangeOrder") OrderHistory exchangeOrder,
                                   @ModelAttribute("exchangeProduct") String exchangeProduct ,
                                   HttpSession session, Model model){
        String exchangerEmail = (String) session.getAttribute("exchEmail");

        model.addAttribute("orders", exchangeOrder);
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currUser = authentication.getName();
        User customer = usrRepo.findByEmail(currUser);
        model.addAttribute("customer", customer.getUsername());

        odrService.addOrder(exchangeOrder, customer);
        List<OrderHistory> Orders = odrService.findUserOrder(customer);
        model.addAttribute("allOrders", Orders);

        return "exchange_saved";

    }




    @PostMapping("/exchange_saved")
    public String showExchangeHistory(@ModelAttribute OrderHistory orderHistory, Model model){
        orderRepo.save(orderHistory);
        String exchangeItem = orderHistory.getExchangeItem();
        model.addAttribute("exchangeItem", exchangeItem);
        model.addAttribute("exchangeMessage", orderHistory.getBuyerMessage());
      //  model.addAttribute("currOrders", orderService);

        return "exchange_saved";
    }






}
