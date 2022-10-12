package com.webapp.paw2paw.repository;


import com.webapp.paw2paw.model.User;
import io.micrometer.core.lang.Nullable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    @Query("SELECT u FROM User u WHERE u.email = ?1")
    @Nullable
    User findByEmail(String email);
   // User findByUsername(String username);

}
