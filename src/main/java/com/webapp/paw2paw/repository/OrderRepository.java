package com.webapp.paw2paw.repository;


import com.webapp.paw2paw.model.OrderHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<OrderHistory, Long> {
    @Query("SELECT o FROM OrderHistory o WHERE o.orderItem = ?1")
    OrderHistory findByProductName(String orderName);


}
