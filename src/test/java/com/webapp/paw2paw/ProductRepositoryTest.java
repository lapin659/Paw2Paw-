package com.webapp.paw2paw;

import com.webapp.paw2paw.model.Product;
import com.webapp.paw2paw.repository.ProductRepository;
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
public class ProductRepositoryTest {

    @Autowired
    private ProductRepository repo;

    @Autowired
    private TestEntityManager entityManager;

    @Test
    public void testCreateProduct(){
        Product product = new Product();
        product.setProductId("111");
        product.setProductName("catbed");
        product.setPrice(20.0);
        product.setDescription("for xxx");

        Product savedProduct = repo.save(product);
        assertThat(savedProduct).isNotNull();
        /**
        Product existProduct = entityManager.find(Product.class, savedProduct.getProductName());
        assertThat(existProduct.getPrice()).isEqualTo(product.getPrice());
**/
    }
/**
    @Test
    public void testFindUserByEmail(){
        String email = "123@gmail.com";
        User user = repo.findByEmail(email);
        assertThat(user).isNotNull();
    }
**/
}
