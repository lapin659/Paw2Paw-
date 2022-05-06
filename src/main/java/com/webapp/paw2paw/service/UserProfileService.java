package com.webapp.paw2paw.service;

import com.webapp.paw2paw.model.User;
import com.webapp.paw2paw.model.UserProfile;
import com.webapp.paw2paw.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserProfileService implements UserDetailsService {

    @Autowired private BCryptPasswordEncoder encoder;

    @Autowired
    private UserRepository userRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepo.findByEmail(username);
        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }
        return new UserProfile(user);
    }

    public void save(User user){
        user.setPassword(encoder.encode(user.getPassword()));
        userRepo.save(user);

    }







}
