package com.webapp.paw2paw.repository;


import com.webapp.paw2paw.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {


}
