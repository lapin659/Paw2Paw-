package com.webapp.paw2paw.controllers;

import com.webapp.paw2paw.model.User;
import com.webapp.paw2paw.repository.UserRepository;
import com.webapp.paw2paw.service.OrderService;
import com.webapp.paw2paw.service.UserProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;

@Controller
public class userProfileController {
    private UserProfileService userProfileService;
    @Autowired
    private UserRepository userRepos;

    @Autowired
    private OrderService orderService;

    @GetMapping({"/login", "login.html"})
    public String showLogin(){

        return "login";

    }


    @GetMapping(value = {"/","/user_profile"})
    //@ResponseBody
    public String userProfile(Principal principal, Model model){

        String currUser = principal.getName();
        model.addAttribute("currUsername", currUser);
        User curr = userRepos.findByEmail(currUser);
       //find order by  user id
        model.addAttribute("myOrders", orderService.findUserOrder(curr));
        //return list of orderhistory
        model.addAttribute("currUser", curr);
        userRepos.save(curr);

        return "user_profile";

    }
/**
    @GetMapping("/exchange")
    public String getExchangeHistory(Model model){
        model.addAttribute("submission", new OrderHistory());
        return "user_profile";
    }

**/
    @PostMapping("/productList")
    public String showUsername(Principal principal, Model model, HttpServletRequest request){
        String currUser = principal.getName();
        model.addAttribute("showUser", currUser);
        String userEmail = request.getUserPrincipal().getName();
        User currU = userRepos.findByEmail(userEmail);
        model.addAttribute("currUser",currU);

        return "productList";
    }


    /**
    @PostMapping("/exchange")
    public String showExchangeHistory(@ModelAttribute OrderHistory orderHistory, Model model){
        String exchangeItem = orderHistory.getExchangeItem();
        model.addAttribute("exchangeItem", exchangeItem);
        return "user_profile";
    }






    @PostMapping("/exchange")
    public String exchangeSubmit(@ModelAttribute ("submission") OrderHistory submission){
       // model.addAttribute("submission", submission);
        System.out.println(submission);
        return "user_profile";
    }


    @Autowired
    private OrderHistory orderhistory;




        @GetMapping({ "","/user_profile"})
        public String currentUser(Principal principal) {
            return principal.getName();
        }

    @GetMapping("/order_history")
    public String exchangeFill(Model model) {
        model.addAttribute("submission", new OrderHistory());
        return "user_profile";
    }


**/


}
