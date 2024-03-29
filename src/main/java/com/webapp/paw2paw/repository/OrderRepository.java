package com.webapp.paw2paw.repository;


import com.webapp.paw2paw.model.OrderHistory;
import com.webapp.paw2paw.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<OrderHistory, Long> {
    @Query("SELECT o FROM OrderHistory o WHERE o.orderId = ?2")
    // @Query("SELECT o FROM OrderHistory o WHERE o.userId = ?1")
    @Nullable
    OrderHistory findOrderHistoryByOrderId(Long orderId);
    //OrderHistory findByProductName(String orderName);

    List<OrderHistory> findByUser(User user);
    List<OrderHistory> findOrderHistoryByUserId(Long userId);

}
