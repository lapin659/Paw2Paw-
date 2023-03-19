package com.webapp.paw2paw.controllers;

import com.webapp.paw2paw.model.OrderHistory;
import com.webapp.paw2paw.model.Product;
import com.webapp.paw2paw.model.User;
import com.webapp.paw2paw.model.UserProfile;
import com.webapp.paw2paw.repository.OrderRepository;
import com.webapp.paw2paw.repository.UserRepository;
import com.webapp.paw2paw.service.OrderService;
import com.webapp.paw2paw.service.ProductService;
import com.webapp.paw2paw.service.UserProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.security.Principal;
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

  private UserProfile userPro;

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

        orderRepo.save(submission);

         model.addAttribute("buyItem", submission.getOrderItem());
         model.addAttribute("message",submission.getBuyerMessage());
         model.addAttribute("currOrders", orderService);

        return "buy_saved";
    }


    @GetMapping("/buy/{productId}")
    public String orderProduct(Model model, @PathVariable("productId") String productId,
                               String buyerEmail, HttpSession session,
                               Principal principal) {

        model.addAttribute("buy", productService.getProductById(productId));

        Product currProduct = productService.getProductById(productId);
        String orderProduct = productService.getProductById(productId).getProductName();


        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userEmail = authentication.getName();
        User currBuyer = userRepo.findByEmail(userEmail);
        Long userId = currBuyer.getId();

        OrderHistory orderHistory = new OrderHistory();
        orderHistory.setOrderItem(orderProduct);
        orderHistory.setUser(currBuyer);
        orderHistory.setOrderId(Long.parseLong(productId));
        orderHistory.setOrderPrice(currProduct.getPrice());
        //model.addAttribute("loggedUser", u);
        orderRepo.save(orderHistory);
        userRepo.save(currBuyer);

        model.addAttribute("currBuyer", currBuyer);
        model.addAttribute("userId", userId);
        model.addAttribute("orderProduct", orderProduct);
        model.addAttribute("currOrder", orderHistory);
      //  model.addAttribute("currOrders", orderService);
        session.setAttribute("currEmail", buyerEmail);

        return "buy";

    }

    @PostMapping("/buy")
    public String newOrder(@ModelAttribute OrderHistory buyOrder, Model model,
                           HttpSession session, HttpServletRequest request,
                           @RequestParam("userId") Long userId){
        //String customerEmail = (String) session.getAttribute("currEmail");

       // orderService.addOrder(buyOrder, userRepo.findByEmail(customerEmail));


       // orderRepo.save(buyOrder);

        model.addAttribute("buyOrder", buyOrder);

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currUser = authentication.getName();
        User customer = userRepo.findByEmail(currUser);
        model.addAttribute("customer", customer.getUsername());


        orderService.addOrder(buyOrder,customer);
        List<OrderHistory> Orders = orderService.findUserOrder(customer);
        model.addAttribute("orders", Orders);

        String contextPath = request.getContextPath();
        //  return new RedirectView(contextPath + "/user_profile/" + userId);
         return "buy_saved";  //"user_profile" raising 500 parsing error

    }


/**
@PostMapping("/buy")
// @ResponseBody
public String addOrder(@RequestParam("orderProduct") String orderProduct,
                             @RequestParam("buyerMessage") String buyerMessage,
                             @RequestParam("orderId") Long orderId) {

    OrderHistory orderHis = new OrderHistory();
    orderHis.setOrderItem(orderProduct);
    orderHis.setOrderId(orderId);
    orderHis.setBuyerMessage(buyerMessage);

    orderRepo.save(orderHis);

    // model.addAttribute("newTopic", topic);
    //    return new RedirectView( contextPath +"/user_profile");
    return "buy_saved";
}


**/









}
