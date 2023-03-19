package com.webapp.paw2paw.service;

import com.webapp.paw2paw.model.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
@Service
public class ProductService {
    public List<Product> getAllProducts(){
        List<Product> listOfProducts = new ArrayList<>();
        listOfProducts.add(new Product("123", "Cat bed", "canned food sampler ", 15, "Cat person A"));
        listOfProducts.add(new Product("124", "Dog leash", "dog toy ", 10, "Dog person B"));
        listOfProducts.add(new Product("125", "1-hr dog walk", "2-day cat sitting ", 20, "Pet person C"));

        return listOfProducts;
    }
    public  Product getProductById(String productId) {

        Predicate<Product> byId = p -> p.getProductId().equals(productId);
        return filterProducts(byId);
    }

    public Product filterProducts(Predicate<Product> strategy) {
        return getAllProducts().stream().filter(strategy).findFirst().orElse(null);
    }

    /**
    @Autowired
    private ProductRepository productRepository;

    public void saveProduct(Product product){
        productRepository.save(product);
    }

**/




}
