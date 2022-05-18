package com.webapp.paw2paw;

import com.webapp.paw2paw.model.OrderHistory;
import com.webapp.paw2paw.model.User;
import com.webapp.paw2paw.repository.OrderRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(value = false)
public class OrderRepositoryTest {

    @Autowired
    private OrderRepository orderRepo;

    @Autowired
    private TestEntityManager entityManager;

    @Test
    public void testCreateOrder(){
        User customer = new User();
        OrderHistory orderHistory = new OrderHistory();
        orderHistory.setOrderItem("dogleash");
        orderHistory.setUser(customer);
        orderHistory.setBuyerMessage("hello");
        orderHistory.setExchangeItem("item1");
        orderHistory.setOrderPrice(10);

        OrderHistory savedOrder = orderRepo.save(orderHistory);
        OrderHistory existOrder = entityManager.find(OrderHistory.class, savedOrder.getOrderId());
        assertThat(existOrder.getOrderItem()).isEqualTo(orderHistory.getOrderItem());

    }

}
