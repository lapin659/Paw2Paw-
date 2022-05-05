package com.webapp.paw2paw.controllers;

import com.webapp.paw2paw.model.OrderHistory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class userProfileController {

    @Autowired
    private OrderHistory orderhistory;


        @RequestMapping({ "","/user_profile"})
        public String userProfile() {
            return "user_profile";
        }
       /**
    @GetMapping("/order_history")
    public String exchangeFill(Model model) {
        model.addAttribute("submission", new OrderHistory());
        return "user_profile";
    }


    @PostMapping("/orders")
    public String exchangeSubmit(@ModelAttribute OrderHistory submission, Model model){
        model.addAttribute("submission", submission);
        return "user_profile";
    }

**/


}
