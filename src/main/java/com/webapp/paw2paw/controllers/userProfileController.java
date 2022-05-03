package com.webapp.paw2paw.controllers;

public class userProfileController {
/**
    @Autowired
    private UserRepository repo;
    @Autowired
    private ProductService productservice;


    @GetMapping("/user_profile")
    public String getUserProfile(Model model, Principal principal){
        String email = principal.getName();
        User user = repo.findByEmail(email);
       // model.addAttribute("orders", productservice.getProductById(id));


        return "userProfile";
    }
**/

}
