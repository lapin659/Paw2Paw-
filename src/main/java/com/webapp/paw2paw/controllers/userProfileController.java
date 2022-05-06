package com.webapp.paw2paw.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;

@Controller
public class userProfileController {

    @GetMapping(value = {"/","/user_profile"})
    //@ResponseBody
    public String userProfile(Principal principal, Model model){
        String currUser = principal.getName();
        model.addAttribute("currUsername", currUser);
        return "user_profile";

    }



    /**
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


    @PostMapping("/orders")
    public String exchangeSubmit(@ModelAttribute OrderHistory submission, Model model){
        model.addAttribute("submission", submission);
        return "user_profile";
    }

**/


}
