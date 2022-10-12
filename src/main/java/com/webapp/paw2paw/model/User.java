package com.webapp.paw2paw.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "userId", unique = true, length = 30)
    private Long id;
    @Column(name = "username", unique = true, length = 20)
    private String username;
    @Column(length = 64)
    private String password;

    public User(Long id, String username, String password, String email, List<OrderHistory> orders) {

        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
        this.orders = orders;
    }

    public User() {
    }

    @Column(unique = true, length = 28)
    private String email;
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<OrderHistory> orders;

    public List<OrderHistory> getOrders() {
        return orders;
    }

    public void setOrders(List<OrderHistory> orders) {
        this.orders = orders;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
