package com.webapp.paw2paw.repository;

import com.webapp.paw2paw.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, String> {
    //@Query("SELECT p FROM Product p WHERE p.productName = ?1")
    //Product findByName(String productName);
}
