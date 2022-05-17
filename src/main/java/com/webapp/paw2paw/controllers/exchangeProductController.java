package com.webapp.paw2paw.controllers;

import com.webapp.paw2paw.model.OrderHistory;
import com.webapp.paw2paw.repository.UserRepository;
import com.webapp.paw2paw.service.OrderService;
import com.webapp.paw2paw.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;

@Controller
public class exchangeProductController {

    @Autowired
    private ProductService prodService;
    @Autowired
    private OrderService odrService;

    @Autowired
    private UserRepository usrRepo;
/**
    @PostMapping("/save_exchange")
    public String exSubmit(Model model,@ModelAttribute ("sub") OrderHistory savedExchange){

        model.addAttribute("exchItem", savedExchange.getOrderItem());
        model.addAttribute("exchMessage",savedExchange.getBuyerMessage());
        model.addAttribute("currExchange", odrService);

        return "exchange_saved";
    }**/

    @GetMapping({"/exchange/{productId}","/exchange"})
    public String exchangeProduct(Model model, @PathVariable("productId") String productId, String exchangeEmail, HttpSession sess){
        model.addAttribute("exchange", prodService.getProductById(productId));
        String exchangeProduct = prodService.getProductById(productId).getProductName();

        OrderHistory exchangeHistory = new OrderHistory();
        exchangeHistory.setOrderItem(exchangeProduct);

       // orderRepos.save(exchangeHistory);
        model.addAttribute("exchangeOrder", exchangeHistory);
        sess.setAttribute("ExchangeEmail",exchangeEmail);
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
    public String addExchangeOrder(@ModelAttribute("exchangedOrder") OrderHistory exchangedHistory, BindingResult bindingResult, HttpSession session){
        String exchangerEmail = (String) session.getAttribute("exchEmail");
        odrService.addOrder(exchangedHistory, usrRepo.findByEmail(exchangerEmail));
        //model.addAttribute("exchangedOrder", exchangedHistory);

        return "exchange_saved";

    }



    /**
    @PostMapping("/exchange")
    public String exchangeSubmit(@ModelAttribute OrderHistory submission, Model model){
        model.addAttribute("submission", submission);
        return "exchange"; //has to be exchange to call submission in template exchange.html
    }

***/

}
