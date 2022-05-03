package com.webapp.paw2paw.repository;

import com.webapp.paw2paw.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
