package com.webapp.paw2paw.controllers;

import com.webapp.paw2paw.model.ForumTopic;
import com.webapp.paw2paw.model.OrderHistory;
import com.webapp.paw2paw.model.User;
import com.webapp.paw2paw.repository.OrderRepository;
import com.webapp.paw2paw.repository.TopicRepository;
import com.webapp.paw2paw.repository.UserRepository;
import com.webapp.paw2paw.service.OrderService;
import com.webapp.paw2paw.service.TopicService;
import com.webapp.paw2paw.service.UserProfileService;
import io.micrometer.core.lang.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;
import java.time.LocalDateTime;
import java.util.List;

@Controller
public class userProfileController {
    private UserProfileService userProfileService;
    @Autowired
    private UserRepository userRepos;

    @Autowired
    private OrderService orderService;
    @Autowired
    private TopicService topicService;

    private final TopicRepository topicRepos;
    @Autowired
    private  OrderRepository orderRepo;

    @Autowired
    public userProfileController(TopicRepository topicRepos,
                                 UserRepository userRepos) {
        this.topicRepos = topicRepos;
        this.userRepos = userRepos;
    }

    @GetMapping({"/login", "login.html"})
    public String showLogin() {

        return "login";

    }


    @GetMapping("/user_profile")
    @Nullable
    public String userProfile(Principal principal, Model model, HttpServletRequest request) {
        // User customer = getAuthenticatedCustomer(request);
        if (!principal.getName().isEmpty()) {
            String currUser = principal.getName();
            model.addAttribute("currUsername", currUser);
            User curr = userRepos.findByEmail(currUser);
            //find order by  user id


            if (!curr.getOrders().isEmpty()){
                List<OrderHistory> currOrders = curr.getOrders();
                model.addAttribute("currOrders", currOrders);
            }else{

                model.addAttribute("nullOrder", new OrderHistory());

            }


            model.addAttribute("myOrders", orderService.findUserOrder(curr));
            //return list of orderhistory
            model.addAttribute("currUser", curr);
            userRepos.save(curr);
        } else {
            model.addAttribute("cru", new User());

        }

        return "user_profile";


    }


    @GetMapping("/user_profile/{userId}")
    public String showProfileById(@PathVariable Long userId, Model model){
        User currUser = userRepos.getById(userId);

        List<OrderHistory> currOrders = orderRepo.findOrderHistoryByUserId(userId);
        List<ForumTopic> currTopics = topicRepos.findForumTopicsByUser_Id(userId);

        model.addAttribute("currUser", currUser);
        model.addAttribute("currOrders", currOrders);
        model.addAttribute("currTopics", currTopics);

        return "user_profile";

    }











/**

    @GetMapping("/productList/{userName}")
    public String showMarketplace(Principal principal, Model model,
                                  @PathVariable("userName") String userName,
                                  HttpServletRequest request) {

        User currUser = userRepos.findByUsername(userName);
        Long userId = currUser.getId();

        model.addAttribute("user", currUser);
        model.addAttribute("userId", userId);

        return "productList";

    }


    @PostMapping("user_profile/{userId}")
    // @ResponseBody
    public RedirectView toMarketplace(
                                @RequestParam("userId") Long userId,
                                HttpServletRequest request) {

        OrderHistory orderHistory = new OrderHistory();
        orderHistory.setOrderId(userId);
        orderHistory.setUser(userRepos.getById(userId));
        orderRepo.save(orderHistory);
        String contextPath = request.getContextPath();
        // model.addAttribute("newTopic", topic);
        //    return new RedirectView( contextPath +"/user_profile");
        return new RedirectView(contextPath + "/productList/" + userId);
    }

**/
    @GetMapping("/exchange_saved")
    public String exchangedFragment() {
        return "user_profile";
    }


    @PostMapping({"/exchange_saved", "/buy_saved"})
    public String showExchangeHistory(@ModelAttribute OrderHistory orderHistory, Model model,
                                      Principal principal, User user) {
        String exchangeItem = orderHistory.getExchangeItem();
        model.addAttribute("exchangeItem", exchangeItem);
        String currEmail = principal.getName();
        model.addAttribute("currUser", user);
        //model.addAttribute("currU", new User());


        return "user_profile";
    }


    @PostMapping("/buy_saved")
    public String showBuyHistory(@ModelAttribute OrderHistory orderHistory, Model model, Principal principal, User user) {
        String buyItem = orderHistory.getOrderItem();
        model.addAttribute("buyItem", buyItem);
        String currEmail = principal.getName();
        model.addAttribute("currUser", user);
        //model.addAttribute("currU", new User());
        return "user_profile";
    }



     @GetMapping("user_profile/{userEmail}")
     public String submitTopic(Model model, @PathVariable("userEmail") String userEmail){
       // model.addAttribute("newTopic", topicService.getTopicById(id));
         User currUser = userRepos.findByEmail(userEmail);
         Long userId = currUser.getId();
        // ForumTopic currTopic = topicService.getTopicById(userId);

         model.addAttribute("user", currUser);
         model.addAttribute("userId", userId);
         model.addAttribute("newTopic", topicService.getTopicById(userId));

        // currUser.setTopics(currTopic);
        return "user_profile";
     }


    @PostMapping("user_profile")
   // @ResponseBody
    public RedirectView addTopic(@RequestParam("title") String title,
                                 @RequestParam("content") String content,
                                 @RequestParam("userId") Long userId,
                                 HttpServletRequest request) {

        ForumTopic topic = new ForumTopic();
        topic.setContent(content);
        topic.setTitle(title);
        topic.setTimeStamp(LocalDateTime.now());
        topic.setUser(userRepos.getById(userId));
        topicRepos.save(topic);
        String contextPath = request.getContextPath();
        // model.addAttribute("newTopic", topic);
        //    return new RedirectView( contextPath +"/user_profile");
        return new RedirectView(contextPath + "/newTopic/" + userId);
    }

}






    /**


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



